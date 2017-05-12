package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Wrapper around a List of Items.
 */
class ResultList {

    private List<Item> resultList;

    ResultList(List<Item> results){
        this.resultList = results;
    }

    /**
     * Returns the size of the resultList.
     */
    public int size() {
        return resultList.size();
    }

    /**
     * Returns true if the resultList contains no elements.
     */
    public boolean isEmpty() {
        return resultList.isEmpty();
    }

    /**
     * Returns a List of models from the resultList of the given type.
     * @param itemType ItemType to search the list for.
     * @param modelInstance Type of model to cast the result to.
     * @return a list of models of type T, or an empty list if no results were found.
     */
    public <T extends Item> List<T> getResultsOfType(Item.ItemType itemType, Class<T> modelInstance){
        List<T> returnList = new ArrayList<>();

        for(Item i : resultList){
            if(i.getType() == itemType){
                returnList.add(modelInstance.cast(i));
            }
        }
        return returnList;
    }

}
