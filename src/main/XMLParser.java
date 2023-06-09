package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import exceptions.EmptyQueueException;
import types.MyQueue;
import types.MyStack;
import types.MyStack.Iterator;

/**
 * Class that uses the MyStack and MyQueue to parse an XML file and show any errors that are in the file
 * @author Matthew, Alex, Quintin, Migule 
 *
 */
public class XMLParser {

	public static void main(String args[]) throws FileNotFoundException, EmptyQueueException {
		File f = new File("res/sample2.xml");
		Scanner file = new Scanner(f);
		MyStack stack = new MyStack();
		MyQueue errorQ = new MyQueue(100);
		MyQueue extrasQ = new MyQueue(100);
		
		//Start of the loop that will keep reading tell it hits the end of the file
		while(file.hasNext()) {
			String tag = file.nextLine();
			tag = tag.trim();
			
			//Process the Tag
			//Checks if its a closing tag
			if(tag.charAt(1) =='/'){
				String tagName = tag.substring(2, tag.indexOf('>'));
				String stacktag = (String) stack.peek();
				try {
					stacktag = stacktag.substring(1, stacktag.indexOf(' '));
				}
				catch(IndexOutOfBoundsException e) {
					stacktag = stacktag.substring(1, stacktag.length()-1);
				}
				
				if(tagName.equals(stacktag)) {
					stack.pop();
				}
				else {
					if(errorQ.size() != 0) {
						String errorQpeek = (String) errorQ.peek();
						errorQpeek = errorQpeek.substring(2, tag.indexOf('>'));
	
						if(tagName.equals(errorQpeek)) {
							errorQ.dequeue();
						}
					}
					if(stack.size() == 0) {
						errorQ.enqueue(tagName);
					}
					else {
						Iterator checkForTag = (Iterator) stack.iterator();
						boolean isInThere = false;
						while(checkForTag.hasNext()) {
							String stackCheck = (String) checkForTag.next();
							try {
								stackCheck = stackCheck.substring(1, stackCheck.indexOf(' '));
							}
							catch(StringIndexOutOfBoundsException e) {
								stackCheck = stackCheck.substring(1, stackCheck.length()-1);
							}
							
							if(stackCheck.equals(tagName)) { 
								isInThere = true;
							}
						}
						if(isInThere) {
							String popTellFind = (String) stack.pop();
							String lineHolder =popTellFind;
							try {
								popTellFind = popTellFind.substring(1, stacktag.indexOf(' '));
							}
							catch(StringIndexOutOfBoundsException e) {
								popTellFind = popTellFind.substring(1, popTellFind.length()-1);
							}
							while(!popTellFind.equals(tagName)) {
								errorQ.enqueue(lineHolder);
								popTellFind = (String) stack.pop();
								try {
									popTellFind = popTellFind.substring(1, popTellFind.indexOf(' '));
								}
								catch(StringIndexOutOfBoundsException e) {
									popTellFind = popTellFind.substring(1, popTellFind.length()-1);
								}
							}
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
				//Checks if its the Starting tag
				else if(tag.charAt(tag.length()-2) == '?' && tag.charAt(1) == '?'){
					
				}
				else if(tag.charAt(tag.length()-2) == '>' && tag.charAt(tag.length()-1) == '>') {
					errorQ.enqueue(tag);
				}
				else {
				stack.push(tag);
				}
			}
			tag = null;
		}
		//after the file is read 
		if(stack.size() == 0 && errorQ.size() == 0 && extrasQ.size() == 0) {
			System.out.println("There is no errors in this XML");
		}
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
			
			while(extrasQ.size() > 0 && errorQ.size()>0) {
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
}
