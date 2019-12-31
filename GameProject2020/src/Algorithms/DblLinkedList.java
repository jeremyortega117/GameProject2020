package Algorithms;

import java.util.LinkedList;

import NPCHuman.NPCHumanObject;

/**
 * Keeps track of the convex hull of the current NPC Objects
 * @author JPOje
 *
 */
public class DblLinkedList{

	// The object for this link
	private NPCHumanObject NPC;

	// The edges forward and back.
	private DblLinkedList next;
	private DblLinkedList prev;


	public DblLinkedList(NPCHumanObject N){
		this.NPC = N;
	}




	public NPCHumanObject getNPC(){
		return NPC;
	}
	public void setNPC(NPCHumanObject N){
		this.NPC = N;
	}



	public DblLinkedList getNext(){
		return next;
	}
	public DblLinkedList getPrev(){
		return prev;
	}



	public void setNext(DblLinkedList N){
		this.next = N;
	}
	public void setPrev(DblLinkedList N){
		this.prev = N;
	}

}
