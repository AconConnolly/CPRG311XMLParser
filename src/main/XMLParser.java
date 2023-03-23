package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class XMLParser {

	public static void main(String args[]) throws FileNotFoundException {
		File f = new File("res/sample1.xml");
		Scanner file = new Scanner(f);
		MyStack stack = new MyStack();
		MyQueue errorQ = new MyQueue();
		MyQueue extrasQ = new MyQueue();
		
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
				String tagName = tag.substring(2, tag.indexOf(' '));
				String stacktag = (String) stack.peek();
				stacktag = stacktag.substring(1, stacktag.indexOf(' '));
				
				String errorQpeek = errorQ.peek();
				errorQpeek = errorQpeek.substring(2, tag.indexOf(' '));
				if(tagName.equals(stacktag)) {
					stack.pop();
				}
				else if(tagName.equals(errorQpeek)) {
					errorQ.dequeu();
				}
				else if(stack.size() == 0) {
					errorQ.enqueu();
				}
				else {
					if(true) { //THis is ment to check if the stack has the matching open tag
						//if found pop stack tell you hit it
						//Everything gets added to the errorQ
					}
					else {
						extrasQ.enqueu();
					}
				}	
			}
			else {
				stack.push(tag);
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
					System.out.println("Error " + (String)errorQ.dequeu());
				}
			}
			else if(extrasQ.size() > 0) {
				while(extrasQ.size() > 0) {
					System.out.println("Error " + (String)extrasQ.dequeu());
				}
			}
		}
		if(extrasQ.size() > 0 && errorQ.size()>0) {
			String errorpeek = (String)errorQ.peek();
			String extraspeek = (String)extrasQ.peek();
			
			if(!errorpeek.equals(extraspeek)) {
				System.out.println("Error " + (String)errorQ.dequeu());
			}
			else {
				errorQ.dequeu();
				extrasQ.deque();
			}
		}
			
		
	}
}
