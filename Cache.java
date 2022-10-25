import java.util.LinkedList;

/**
 * @author Braeden LaCombe
 *
 * Cache class holds all of the methods needed for the cache. This includes adding and removing objects
 * printing out cache information, and calculating cache information. 
 *
 * @param <T>
 */
public class Cache<T>
{
	//Basics for cache
	//The LinkedList cache
	LinkedList<T> cache;
	//Counters for how many references and how many hits in the cache
	double cacheReferences, cacheHits;
	//Max values in list
	int cacheMaxSize;
	
	/**
	 * Cache constructor, taking in the size of the cache when implemented in main method and
	 * ensuring that the cache does not exceed the given size
	 **/
	public Cache(int cacheSize)
	{
		cacheReferences = 0;
		cacheHits = 0;
		cacheMaxSize = cacheSize;
		cache = new LinkedList<T>();
	}
	
	/**
	 * Searches through the cache for an object and returns it if found, as well as moving it to the top of the cache
	 * @param retriveObject - takes in an object that is being searched for
	 * @return the T object from the cache or the new object that just got inserted
	 */
	public T getObject(T retriveObject)
	{
		cacheReferences++;
		//Move through all items in cache
		for(T n : cache)
		{
			//Check for object
			if(n.equals(retriveObject))
			{
				cacheHits++;
				//Set object to front of cache and return it
				//Remove then add will take it from position and move it to front
				removeObject(n);
				addObject(n);
				return n;
			}
		}
		//If at this point, object was not found
		//First, check for full cache
		if(cache.size() == cacheMaxSize)
		{
			//If full, remove last object
			cache.removeLast();
			//Then add the new object to front
			addObject(retriveObject);
			return retriveObject;
		}
		//Else, cache has space so just add object to front
		else
		{
			addObject(retriveObject);
			return(retriveObject);
		}
		
	}
	/**
	 * Prints out the information about the cache to the console
	 */
	public void printCacheStats()
	{
		System.out.println("Total number of references: " + cacheReferences);
		System.out.println("Total number of cache hits: " + cacheHits);
		//System.out.println("1st-level cache hit ration: " + (cacheHits/cacheReferences));			
		
		if(cacheReferences == 0)
		{
			System.out.println("1st-level cache hit ration: 0");
		}
		else
		{
			double cacheRatio = cacheHits / cacheReferences;
			System.out.println("1st-level cache hit ration: " + cacheRatio);			
		}
		System.out.println();
	}
	/**
	 * Adds a given object to the front of the cache
	 * @param input - object to be added
	 */
	public void addObject(T input)
	{
		cache.addFirst(input);
	}
	/**
	 * Removes a given object from the list, assuming it exists
	 * @param objectToRemove - object to remove
	 */
	public void removeObject(T objectToRemove)
	{
		cache.remove(objectToRemove);
	}
	/**
	 * Removes all items from the cache
	 */
	public void clearCache()
	{
		cache.clear();
	}
	/**
	 * Standard toString method for the cache
	 */
	public String toString()
	{
		return cache.toString();
	}

	/**
	 * Returns the reference value for the cache
	 * @return cacheReferences - reference count
	 */
	public double getReferences()
	{
		return cacheReferences;
	}
	/**
	 * Set the reference count to given value
	 * @param referenceCount - sets the references to the new given count
	 */
	public void setReferences(int referenceCount)
	{
		cacheReferences = referenceCount;
	}
	/**
	 * Return the number of hits from the cache
	 * @return cacheHits - cache hit count
	 */
	public double getHits()
	{
		return cacheHits;
	}
	/**
	 * Set the cache hit count to the given value
	 * @param hitCount - new hit value
	 */
	public void setHits(int hitCount)
	{
		cacheHits = hitCount;
	}
}
