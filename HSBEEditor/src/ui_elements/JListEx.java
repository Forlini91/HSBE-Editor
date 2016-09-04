package ui_elements;

import java.util.Arrays;
import java.util.Collection;
import java.util.Vector;

import javax.swing.JList;
import javax.swing.ListSelectionModel;

import interfaces.JExtended;

/**
 * A JList with useful methods to manipulate the data.
 * @author MarcoForlini
 * @param <E>	the type of the elements of this list
 */
public class JListEx<E> extends JList<E> implements JExtended<E> {
	
	private Vector<E> elements;
	private static final long serialVersionUID = 1L;
	
	/**
	 * Create a new JLiseEx
	 */
	public JListEx(){
		this(new Vector<>(), false);
	}
	
	/**
	 * Create a new JLiseEx
	 * @param data	The initial data
	 */
	public JListEx (E[] data){
		this(new Vector<>(Arrays.asList(data)), false);
	}
	
	/**
	 * Create a new JLiseEx
	 * @param data	The initial data
	 */
	public JListEx (Vector<E> data){
		this(data, false);
	}
	
	/**
	 * Create a new JLiseEx
	 * @param data		The initial data
	 * @param sorted	If true, elements are sorted
	 */
	public JListEx (E[] data, boolean sorted){
		this(new Vector<>(Arrays.asList(data)), sorted);
	}
	
	/**
	 * Create a new JLiseEx
	 * @param data		The initial data
	 * @param sorted	If true, elements are sorted
	 */
	public JListEx (Vector<E> data, boolean sorted){
		super();
		setVector(data, sorted);
		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		setVisibleRowCount(10);
	}
	
	@Override
	public Vector<E> getVector(){
		return elements;
	}
	
	@Override
	public void setVector(E[] newElements){
		setVector(new Vector<>(Arrays.asList(newElements)), false);
	}
	
	@Override
	public void setVector(Vector<E> newElements){
		setVector(newElements, false);
	}
	
	@Override
	public void setVector(E[] newElements, boolean sorted){
		setVector(new Vector<>(Arrays.asList(newElements)), sorted);
	}
	
	@Override
	public void setVector(Vector<E> newElements, boolean sorted){
		elements = new Vector<>(newElements);
		if (sorted) {
			sort();
		}
		refresh();
	}
	
	@Override
	public int getLength(){
		return elements.size();
	}
	
	@Override
	public E getSelectedElement(){
		return getSelectedValue();
	}
	
	@Override
	public void setSelectedElement(E element){
		setSelectedValue(element, false);
	}
	
	@Override
	public void setSelectedElement(E element, boolean showElement){
		setSelectedValue(element, showElement);
	}
	
	@Override
	public void setSelectedIndex(int index, boolean showElement){
		setSelectedValue(elements.get(index), showElement);
	}
	
	@Override
	public E get(int index){
		return elements.get(index);
	}
	
	@Override
	public int indexOf(E element){
		return elements.indexOf(element);
	}
	
	@Override
	public int add(E element){
		return add(element, -1, false);
	}
	
	@Override
	public int add(E element, int index){
		return add(element, index, false);
	}
	
	@Override
	public int add(E element, boolean sorted){
		return add(element, -1, sorted);
	}
	
	@Override
	public int add(E element, int index, boolean sorted){
		if (index < 0) {
			elements.add(element);
		} else {
			elements.add(index, element);
		}
		if (sorted) {
			sort();
		}
		refresh();
		setSelectedValue(element, true);
		if (index >= 0) {
			return index;
		}
		return getSelectedIndex();
	}
	
	@Override
	public int drop(E element){
		int index = indexOf(element);
		if (index == -1) {
			return -1;
		}
		drop(index);
		return index;
	}
	
	@Override
	public E drop(int index) throws ArrayIndexOutOfBoundsException {
		E element = elements.remove(index);
		refresh();
		if (index < elements.size()){
			setSelectedIndex(index);
		}
		else{
			setSelectedIndex(elements.size()-1);
		}
		return element;
	}
	
	@Override
	public void addAll(JExtended<E> other){
		addAll(other.getVector(), false);
	}
	
	@Override
	public void addAll(JExtended<E> other, boolean sorted){
		addAll(other.getVector(), sorted);
	}
	
	@Override
	public void addAll(Collection<E> other){
		addAll(other, false);
	}
	
	@Override
	public void addAll(Collection <E> other, boolean sorted){
		elements.addAll(other);
		if (sorted) {
			sort();
		}
		refresh();
	}
	
	@Override
	public void dropAll(int...indexes){
		for (int index : indexes){
			if (index >= getLength()){
				return;
			}
			elements.remove(index);
		}
		refresh();
	}
	
	@Override
	public void dropAll(Collection<E> other){
		elements.retainAll(other);
		refresh();
	}
	
	@Override
	public int transferTo(E element, JExtended<E> other){
		return transferTo(elements.indexOf(element), other, false);
	}
	
	@Override
	public int transferTo(E element, JExtended<E> other, boolean sorted){
		return transferTo(elements.indexOf(element), other, sorted);
	}
	
	@Override
	public int transferTo(int element, JExtended<E> other){
		return transferTo(element, other, false);
	}
	
	@Override
	public int transferTo(int element, JExtended<E> other, boolean sorted){
		if (element == -1) {
			return -1;
		}
		E transfered = drop(element);
		if (transfered == null) {
			return -2;
		}
		
		other.add(transfered, sorted);
		other.setSelectedElement(transfered, true);
		if (element < elements.size()){
			setSelectedIndex(element);
			return element;
		}
		setSelectedIndex(elements.size()-1);
		return elements.size()-1;
	}
	
	@Override
	public void transferAll(JExtended<E> other, boolean sorted){
		other.addAll(elements, sorted);
		elements.clear();
		refresh();
	}
	
	@Override
	public E moveUp(E element){
		return moveUp(indexOf(element));
	}
	
	@Override
	public E moveUp(int element){
		if (element < 1) {
			return null;
		}
		switchElements(element, element-1);
		return elements.get(element);		//return the other element
	}
	
	@Override
	public E moveDown(E element){
		return moveDown(indexOf(element));
	}
	
	@Override
	public E moveDown(int element){
		if (element == elements.size()-1) {
			return null;
		}
		switchElements(element, element+1);
		return elements.get(element);		//return the other element
	}
	
	@Override
	public void switchElements(int indexA, int indexB){
		switchElements(elements.get(indexA), indexA, elements.get(indexB), indexB);
	}
	
	@Override
	public void switchElements(E elemA, E elemB){
		switchElements(elemA, indexOf(elemA), elemB, indexOf(elemB));
	}
	
	@Override
	public void switchElements(E elemA, int indexA, E elemB, int indexB){
		elements.set(indexB, elemA);
		elements.set(indexA, elemB);
		refresh();
	}
	
	@Override
	public Vector<E> sort(){
		return sort(false);
	}
	
	@Override
	public Vector<E> sort(boolean refresh){
		if (refresh) {
			return refresh(sort(elements));
		}
		return sort(elements);
	}
	
	@Override
	public Vector<E> sort(Vector<E> elements){
		elements.sort(null);
		return elements;
	}
	
	@Override
	public Vector<E> refresh(){
		setListData(elements);
		return elements;
	}
	
	@Override
	public Vector<E> refresh(Vector<E> elements){
		setListData(elements);
		return elements;
	}
	
}
