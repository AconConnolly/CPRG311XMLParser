package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import exceptions.EmptyQueueException;
import types.MyQueue;
import types.MyStack;
import types.MyStack.Iterator;


public class XMLParser {

	public static void main(String args[]) throws FileNotFoundException, EmptyQueueException {
		File f = new File("res/sample1.xml");
		Scanner file = new Scanner(f);
		MyStack stack = new MyStack();
		MyQueue errorQ = new MyQueue(100);
		MyQueue extrasQ = new MyQueue(100);
		//Dont like that i have to put size in there 
		while(file.hasNext()) {
			//Read until subString at end = >
			String tag = file.next();
			while(!tag.substring(tag.length()-1).equals(">")) {
				if(file.hasNext()) {
					tag += " ";
					tag +=file.next();
				}
			}	
			//Process the Tag
			if(tag.charAt(1) =='/'){
				String tagName = tag.substring(2, tag.indexOf('>'));
				String stacktag = (String) stack.peek();
				stacktag = stacktag.substring(1, stacktag.indexOf(' '));
				
				if(errorQ.size() != 0) {
					String errorQpeek = (String) errorQ.peek();
					errorQpeek = errorQpeek.substring(2, tag.indexOf('>'));
					if(tagName.equals(stacktag)) {
						stack.pop();
					}
					else if(tagName.equals(errorQpeek)) {
						errorQ.dequeue();
					}
					else if(stack.size() == 0) {
						errorQ.enqueue(tagName);
					}
					else {
						Iterator checkForTag = (Iterator) stack.iterator();
						boolean isInThere = false;
						while(checkForTag.hasNext()) {
							String stackCheck = (String) checkForTag.next();
							stackCheck = stackCheck.substring(1, stacktag.indexOf(' '));
							
							if(stackCheck.equals(tagName)) { 
								isInThere = true;
							}
						}
						if(isInThere) {
							String popTellFind = (String) stack.pop();
							popTellFind = popTellFind.substring(1, stacktag.indexOf(' '));
							while(popTellFind != tagName) {
								errorQ.enqueue(popTellFind);
								popTellFind = (String) stack.pop();
								popTellFind = popTellFind.substring(1, stacktag.indexOf(' '));
							}
							errorQ.enqueue(popTellFind);
						}
						else {
							extrasQ.enqueue(tagName);
						}
					}
				}
					
					
			}
			else {
				//Check for a self closing tag char at index of length - 2 should be "/"
				if(tag.charAt(tag.length()-2) == '/') {
					
				}
				else {
				stack.push(tag);
				}
			}
			//System.out.println(tag);
			tag = null;
		}
		//after the file is read 
		if(stack.size()>0) {
			while(stack.size()>0) {
				errorQ.enqueue(stack.pop());
			}
		}
		if((errorQ.size() == 0 && extrasQ.size() > 0)|| (extrasQ.size() == 0 && errorQ.size()>0)) {
			if(errorQ.size() > 0) {
				while(errorQ.size() > 0) {
					System.out.println("Error " + (String)errorQ.dequeue());
				}
			}
			else if(extrasQ.size() > 0) {
				while(extrasQ.size() > 0) {
					System.out.println("Error " + (String)extrasQ.dequeue());
				}
			}
		}
		if(extrasQ.size() > 0 && errorQ.size()>0) {
			String errorpeek = (String)errorQ.peek();
			String extraspeek = (String)extrasQ.peek();
			
			if(!errorpeek.equals(extraspeek)) {
				System.out.println("Error " + (String)errorQ.dequeue());
			}
			else {
				errorQ.dequeue();
				extrasQ.dequeue();
			}
		}
			
		
	}
}
