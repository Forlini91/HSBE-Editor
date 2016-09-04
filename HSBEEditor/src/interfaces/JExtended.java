package interfaces;

import java.util.Collection;
import java.util.Vector;

/**
 * Declare many useful methods for JList and JComboBox components
 * @author MarcoForlini
 * @param <E>	type of elements
 */
public interface JExtended<E> {
	
	/**
	 * Return the elements
	 * @return	The elements
	 */
	public Vector<E> getVector();
	
	/**
	 * Set the elements
	 * @param newElements	The elements
	 */
	public void setVector(E[] newElements);
	
	/**
	 * Set the elements
	 * @param newElements	The elements
	 */
	public void setVector(Vector<E> newElements);
	
	/**
	 * Set the elements
	 * @param newElements	The elements
	 * @param sorted		If true, elements will be sorted
	 */
	public void setVector(E[] newElements, boolean sorted);
	
	/**
	 * Set the elements
	 * @param newElements	The elements
	 * @param sorted		If true, elements will be sorted
	 */
	public void setVector(Vector<E> newElements, boolean sorted);
	
	/**
	 * Get the number of elements
	 * @return	The number of elements
	 */
	public int getLength();
	
	/**
	 * Get the selected element
	 * @return	The selected element
	 */
	public E getSelectedElement();
	
	/**
	 * Get the selected element's index
	 * @return	The selected element's index
	 */
	public int getSelectedIndex();
	
	/**
	 * Select the given element
	 * @param element	The element to select
	 */
	public void setSelectedElement(E element);
	
	/**
	 * Select the given element
	 * @param element		The element to select
	 * @param showElement	If true, show the selected element
	 */
	public void setSelectedElement(E element, boolean showElement);
	
	/**
	 * Select the element at the given index
	 * @param index		The element's index
	 */
	public void setSelectedIndex(int index);
	
	/**
	 * Select the element at the given index
	 * @param index			The element's index
	 * @param showElement	If true, show the selected element
	 */
	public void setSelectedIndex(int index, boolean showElement);
	
	/**
	 * Get the element at the given index
	 * @param index		The index of the element
	 * @return			The element at the given index
	 */
	public E get(int index);
	
	/**
	 * Search the index of the given element
	 * @param element	The element to search
	 * @return			The element index if present, -1 otherwise
	 */
	public int indexOf(E element);
	
	/**
	 * Add the given element
	 * @param element	The element to add
	 * @return			The position of the element
	 */
	public int add(E element);
	
	/**
	 * Add the given element
	 * @param element	The element to add
	 * @param index		Position of the new element
	 * @return			The position of the element
	 */
	public int add(E element, int index);
	
	/**
	 * Add the given element
	 * @param element	The element to add
	 * @param sorted	If true, sort the elements after the addition
	 * @return			The position of the element
	 */
	public int add(E element, boolean sorted);
	
	/**
	 * Add the given element
	 * @param element	The element to add
	 * @param index		Position of the new element
	 * @param sorted	If true, sort the elements after the addition
	 * @return			The position of the element
	 */
	public int add(E element, int index, boolean sorted);
	
	/**
	 * Remove the given element
	 * @param element	The element to remove
	 * @return			The element position
	 */
	public int drop(E element);

	/**
	 * Remove the element at the given index
	 * @param index		Index of the element to remove
	 * @return			The element removed
	 */
	public E drop(int index);
	
	/**
	 * Add all elements from the given JExtended
	 * @param other		The JExtended list to merge
	 */
	public void addAll(JExtended<E> other);
	
	/**
	 * Add all elements from the given JExtended
	 * @param other		The JExtended list to merge
	 * @param sorted	If true, sort the elements after the addition
	 */
	public void addAll(JExtended<E> other, boolean sorted);
	
	/**
	 * Add all elements from the given JExtended
	 * @param other		The JExtended list to merge
	 */
	public void addAll(Collection<E> other);
	
	/**
	 * Add all elements from the given JExtended
	 * @param other		The JExtended list to merge
	 * @param sorted	If true, sort the elements after the addition
	 */
	public void addAll(Collection<E> other, boolean sorted);
	
	/**
	 * Remove all elements at the given indexes
	 * @param indexes	All elements indexes
	 */
	public void dropAll(int...indexes);
	
	/**
	 * Remove from this collection all elements which are presents in the other collection
	 * @param other		Remove these elements
	 */
	public void dropAll(Collection<E> other);
	
	/**
	 * Transfer the given element to the given JExtended
	 * @param element	Element to transfer
	 * @param other		The other JExtended
	 * @return			The new element's position
	 */
	public int transferTo(E element, JExtended<E> other);
	
	/**
	 * Transfer the given element to the given JExtended
	 * @param element	Element to transfer
	 * @param other		The other JExtended
	 * @param sorted	Sort the given JExtended after the transfer
	 * @return			The new element's position
	 */
	public int transferTo(E element, JExtended<E> other, boolean sorted);
	
	/**
	 * Transfer the element at the given index to the given JExtended
	 * @param element	Index of the element to transfer
	 * @param other		The other JExtended
	 * @return			The new element's position
	 */
	public int transferTo(int element, JExtended<E> other);
	
	/**
	 * Transfer the element at the given index to the given JExtended
	 * @param element	Index of the element to transfer
	 * @param other		The other JExtended
	 * @param sorted	Sort the given JExtended after the transfer
	 * @return			The new element's position
	 */
	public int transferTo(int element, JExtended<E> other, boolean sorted);
	
	/**
	 * Transfer all elements to the given JExtended
	 * @param other		The other JExtended
	 * @param sorted	Sort the given JExtended after the transfer
	 */
	public void transferAll(JExtended<E> other, boolean sorted);
	
	/**
	 * Move the given element up in the list
	 * @param element	The element to move
	 * @return			The element which was previously above (and now below)
	 */
	public E moveUp(E element);
	
	/**
	 * Move the element at the given index up in the list
	 * @param element	The index of the element to move
	 * @return			The element which was previously above (and now below)
	 */
	public E moveUp(int element);
	
	/**
	 * Move the given element down in the list
	 * @param element	The element to move
	 * @return			The element which was previously below (and now above)
	 */
	public E moveDown(E element);
	
	/**
	 * Move the element at the given down in the list
	 * @param element	The index of the element to move
	 * @return			The element which was previously below (and now above)
	 */
	public E moveDown(int element);
	
	/**
	 * Switch the given elements position
	 * @param indexA	Index of an element
	 * @param indexB	Index of another element
	 */
	public void switchElements(int indexA, int indexB);
	
	/**
	 * Switch the given elements position
	 * @param elemA		An element
	 * @param elemB		Another element
	 */
	public void switchElements(E elemA, E elemB);
	
	/**
	 * Set the given elements position
	 * @param elemA		An element
	 * @param indexA	Index of the first element
	 * @param elemB		Another element
	 * @param indexB	Index of the second element
	 */
	public void switchElements(E elemA, int indexA, E elemB, int indexB);
	
	/**
	 * Sort the elements
	 * @return	The sorted vector
	 */
	public Vector<E> sort();
	
	/**
	 * Sort the elements
	 * @param refresh	If true, update the elements before sorting
	 * @return			The sorted elements
	 */
	public Vector<E> sort(boolean refresh);
	
	/**
	 * Sort the given elements
	 * @param elements	The elements to sort
	 * @return			The sorted elements
	 */
	public Vector<E> sort(Vector<E> elements);
	
	/**
	 * Update the elements
	 * @return	The vector
	 */
	public Vector<E> refresh();
	
	/**
	 * Update the given elements
	 * @param elements	The elements to update
	 * @return			The vector
	 */
	public Vector<E> refresh(Vector<E> elements);
	
}
