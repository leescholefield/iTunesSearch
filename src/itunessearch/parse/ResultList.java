package itunessearch.parse;

import itunessearch.model.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

/**
 * Wrapper around a List of Items.
 */
public final class ResultList<T extends Item> {

    private List<T> resultList;

    ResultList(List<T> results){
        this.resultList = results;
    }

    /**
     * Returns the size of the resultList. Delegates to the resultList.size() method.
     */
    public int size() {
        return resultList.size();
    }

    /**
     * Returns true if the resultList contains no elements. Delegates to the resultList.isEmpty() method.
     */
    public boolean isEmpty() {
        return resultList.isEmpty();
    }

    /**
     * Searches the resultList for items that match the given ItemType then casts them to the given modelInstance.
     *
     * Note, itemType and modelInstance must be subclasses of T.
     *
     * @param itemType ItemType to search the list for.
     * @param modelInstance Type of itunessearch.model to cast the result to.
     * @param <T2> a subclass of Item, and a subclass of T
     * @return a list of models of type T, or an empty list if no results were found.
     */
    public <T2 extends T> ResultList<T2> getResultsOfType(Item.ItemType itemType, Class<T2> modelInstance){
        List<T2> returnList = new ArrayList<>();

        for(Item i : resultList){
            if(i.getType() == itemType){
                returnList.add(modelInstance.cast(i));
            }
        }
        return new ResultList<T2>(returnList);
    }

    /**
     * Returns resultList as an UnmodifiableList.
     */
    public List<T> getResultList(){
        return Collections.unmodifiableList(resultList);
    }

    /**
     * Returns a new Iterator<T> object. This delegates to the Iterator obtained by calling resultList.iterator(),
     * however this one does not support the remove() method.
     *
     * @throws UnsupportedOperationException if the remove() is called.
     */
    public Iterator<T> iterator(){

        return new Iterator<T>() {
            Iterator<T> innerIter = resultList.iterator();
            @Override
            public boolean hasNext() {
                return innerIter.hasNext();
            }

            @Override
            public T next() {
                return innerIter.next();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Cannot modify the resultList");
            }

            @Override
            public void forEachRemaining(Consumer<? super T> action) {
                innerIter.forEachRemaining(action);
            }
        };
    }

}
