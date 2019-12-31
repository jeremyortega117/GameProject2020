package Algorithms;

import NPCHuman.NPCHumanObject;

public class NPCMap_Jarvis {

	private DblLinkedList head;
	private DblLinkedList curr;
	private DblLinkedList prev;
	private DblLinkedList topEnd;
	private int size;

	// Gathers and runs the algorithm for the jarvise's march
	public NPCMap_Jarvis(int size){
		this.size = size;
	}

	public DblLinkedList getHead(){
		return head;
	}
	public DblLinkedList getTopEnd(){
		return topEnd;
	}


	public void algoTop(NPCHumanObject[] NPC){
		// check if we need to perform a convex hull algorithm.
		if(lessThanTwoCheck(NPC))
			return;

		// Go through all but the first and last index's
		for(int trav = 2; trav < size; trav++){

			// find out if the current point is part of the convex hull or not.
			double hullCheck = hullCheck(NPC, prev, curr, trav);
			DblLinkedList DLL = new DblLinkedList(NPC[trav]);

			/*
			 * Check if the convex Hull should be outside of the current node
			 */
			if(hullCheck < curr.getNPC().getPosY()){

				/*
				 * Check each previous node on the convex hull until up until we are sure no current
				 * node will be fully contained in the new convex hull.
				 */
				while(prev != head){
					/*
					 * Check each new convex hull compared to the previous node.
					 */
					double newHullCheck = hullCheck(NPC, prev.getPrev(), prev, trav);
					if(newHullCheck < prev.getNPC().getPosY()){
						prev = prev.getPrev();
						prev.setNext(DLL);
					}
					/*
					 * once we verify that we've found a previous convex hull node that won't change from the
					 * current new node, we quit.
					 */
					else{
						break;
					}
				}
				/*
				 * This handles the same situation as directly above but takes care not to go past the
				 * head.
				 */
				if(prev == head){
					double newHullCheck = hullCheck(NPC, prev, prev.getNext(), trav);
					if(newHullCheck < prev.getNPC().getPosY()){
						prev.setNext(DLL);
					}
				}
				/*
				 * update the connection between the new next convex hull node and the last verified node
				 * on the convex hull.
				 */
				DLL.setPrev(prev);
				prev.setNext(DLL);
			}

			/*
			 * If the Current Node is Outside the convex hull Then it becomes a part of the new
			 * convex hull
			 */
			else{
				curr.setNext(DLL);
				DLL.setPrev(curr);
				prev = curr;
			}
			/*
			 * update the current node along the convex hull.
			 */
			curr = DLL;
			// printCurrList();
		}
		topEnd = curr;
		algoBottom(NPC);
	}

/**
 * Same as above however swapped the LESS with GREATER signs when checking if vertex are
 * apart of the convex hull.
 * @param NPC
 */
	public void algoBottom(NPCHumanObject[] NPC){

		DblLinkedList DLL_1 = new DblLinkedList(NPC[size-1]);
		DLL_1.setPrev(topEnd);
		topEnd.setNext(DLL_1);

		prev = topEnd;
		curr = DLL_1;

		// Go through all but the first and last index's
		for(int trav = size-2; trav > -1; trav--){

			// find out if the current point is part of the convex hull or not.
			// double hullCheck = hullCheck(NPC, prev, curr, trav);
			double hullCheck = hullCheckBottom(NPC, prev, curr, trav);
			DblLinkedList DLL = new DblLinkedList(NPC[trav]);

			/*
			 * Check if the convex Hull should be outside of the current node
			 */
			if(hullCheck > curr.getNPC().getPosY()){

				/*
				 * Check each previous node on the convex hull until up until we are sure no current
				 * node will be fully contained in the new convex hull.
				 */
				while(prev != topEnd){
					/*
					 * Check each new convex hull compared to the previous node.
					 */
					double newHullCheck = hullCheckBottom(NPC, prev.getPrev(), prev, trav);
					if(newHullCheck > prev.getNPC().getPosY()){
						prev = prev.getPrev();
						prev.setNext(DLL);
					}
					/*
					 * once we verify that we've found a previous convex hull node that won't change from the
					 * current new node, we quit.
					 */
					else{
						break;
					}
				}
				/*
				 * This handles the same situation as directly above but takes care not to go past the
				 * head.
				 */
				if(prev == topEnd){
					double newHullCheck = hullCheckBottom(NPC, prev, prev.getNext(), trav);
					if(newHullCheck > prev.getNPC().getPosY()){
						prev.setNext(DLL);
					}
				}
				/*
				 * update the connection between the new next convex hull node and the last verified node
				 * on the convex hull.
				 */
				DLL.setPrev(prev);
				prev.setNext(DLL);
			}

			/*
			 * If the Current Node is Outside the convex hull Then it becomes a part of the new
			 * convex hull
			 */
			else{
				curr.setNext(DLL);
				DLL.setPrev(curr);
				prev = curr;
			}
			/*
			 * update the current node along the convex hull.
			 */
			curr = DLL;
			//printCurrList();
		}
		topEnd = curr;
		printCurrList();
	}


	/**
	 * Check if the number of NPC's in an area are 2 or less.
	 * @param NPC
	 * @return
	 */
	private Boolean lessThanTwoCheck(NPCHumanObject[] NPC){
		// NPCs are zero
		if(NPC.length == 0){
			return true;
		}
		// create first linked list node.
		head = new DblLinkedList(NPC[0]);
		prev = head;
		if(NPC.length == 1){
			return true;
		}
		// Else prepare the second linked list.
		DblLinkedList DLL_Two = new DblLinkedList(NPC[1]);
		head.setNext(DLL_Two);
		DLL_Two.setPrev(head);
		curr = DLL_Two;
		if(NPC.length == 2){
			return true;
		}
		return false;
	}

	/**
	 * return the knowledge of whether or not a new point along the convex hull has been found.
	 * @param NPC
	 * @param pre
	 * @param trav
	 * @return
	 */
	public double hullCheck(NPCHumanObject[] NPC, DblLinkedList prev, DblLinkedList currCheck, int trav){

		double nextX = NPC[trav].getPosX();
		double nextY = NPC[trav].getPosY();

		double prevX = prev.getNPC().getPosX();
		double prevY = prev.getNPC().getPosY();

		double thisX = currCheck.getNPC().getPosX();


		// (3, 2) and (6, 3) // y = mx + b
		double slope = (nextY-prevY) / (nextX-prevX);  // m
		double yInt = prevY - (slope * prevX);  // b

		// If this is lower than current point, the current point is no longer
		// a part of the hull.

		return slope*thisX + yInt;
	}
	/**
	 * Same as above but swapped the prev and next X and Y values so the slope intercept formula still works.
	 * @param NPC
	 * @param prev
	 * @param currCheck
	 * @param trav
	 * @return
	 */
	public double hullCheckBottom(NPCHumanObject[] NPC, DblLinkedList prev, DblLinkedList currCheck, int trav){

		double prevX = NPC[trav].getPosX();
		double prevY = NPC[trav].getPosY();

		double nextX = prev.getNPC().getPosX();
		double nextY = prev.getNPC().getPosY();

		double thisX = currCheck.getNPC().getPosX();


		// (3, 2) and (6, 3) // y = mx + b
		double slope = (nextY-prevY) / (nextX-prevX);  // m
		double yInt = prevY - (slope * prevX);  // b

		// If this is lower than current point, the current point is no longer
		// a part of the hull.

		return slope*thisX + yInt;
	}

	public void printCurrList(){
		DblLinkedList Dbl = head;
		while(Dbl.getNext() != null){
			System.out.print(""+Dbl.getNPC().getId()+", ");
			Dbl = Dbl.getNext();
		}
		System.out.println(""+Dbl.getNPC().getId());
	}
}
