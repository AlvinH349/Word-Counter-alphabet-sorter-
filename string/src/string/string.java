//Alvin Huang 1115 HW: Topic 8 Program: Word Count Resubmit
package string;
import java.io.*;
import java.util.Scanner;

public class string {

	public static void main(String[] args) throws IOException {
		
		PrintWriter out= new PrintWriter("/Users/alvinhuang/Documents/outwordcount1.txt");
		
		//PrintWriter out= new PrintWriter(System.out);
		
		File infile= new File("/Users/alvinhuang/Documents/inwordcount.txt");
		
		Scanner in= new Scanner(infile);
		
		//Scanner in= new Scanner(System.in);
		
		out.println("Alvin Huang 1115 HW: Topic 8 Program: Word Count\n\n");
		
		final int totalwords=100;
		int totwords=totalwords;
		int num_of_words=0;
		final int totalcount=100;
		int totcount=totalcount;
		
		
		
		
		
		
		String []words_in_sentence= new String [totwords];
		
		int []count=new int[totcount];
	     
	      
	     
		
		
		out.flush();
		num_of_words=read_sentence(words_in_sentence,num_of_words,totwords,in,out);
		
	    
		
		
		num_of_words=counting(words_in_sentence, count, num_of_words,totcount, in, out);
		
		alpha(words_in_sentence,count, num_of_words, totcount,  in, out);
		
		
		
		
		in.close();
		out.close();
	}
		
		/* Method read_sentence()
		 input:
	     word_in_sentence- array that holds all the words of the sentences
	     num_of_words- number of words
	     totwords- total of max words
	     in- reference to input file
	     out- reference to output file
		 
		 process:
	     reads the whole sentence
		 
		 output:
		 print the sentence
		 returns number of words
		 
		 */

		public static int read_sentence(String []words_in_sentence,int num_of_words,int totwords,Scanner in,PrintWriter out)
		{
			
			
			
			
			
		
		    
			words_in_sentence[num_of_words]=in.next();
			out.print(words_in_sentence[num_of_words]+" ");
			 //words_in_sentence[num_of_words]=words_in_sentence[num_of_words].toLowerCase();
			
			
			while(in.hasNext() && num_of_words<totwords){
			   
				
		     
				num_of_words++;
				words_in_sentence[num_of_words]=in.next();
				out.print(words_in_sentence[num_of_words]+" ");
		        
		      
		      
		     
		      
		      
		   
		       
		   }//close of while
			num_of_words++;
			
			words_in_sentence[num_of_words-1] =  words_in_sentence[num_of_words-1].replace("."," ");
			
			
			return num_of_words;
			
			
		}
		
		
	
		
		/* Method counting()
		 input:
	     words_in_sentence-words in the sentence
	     count-counts the number of the same words
	     num_of_words-number of words counted
	     totcount- max amount of words were counted as the same type
	     in- reference to input file
	     out- reference to output file
		 
		 process:
	     store the appearance count for each word
	     
		 
		 output:
		 return num_of_words
		 
		 */
		
		public static int counting(String []words_in_sentence,int[]count,int num_of_words,int totcount, Scanner in,PrintWriter out) {
			
			
    
			
			
			
			// give numbers how many types of words are there in each
			int b=0;
			
			for(int a=0; a<num_of_words;a++) 
			
				{// opening of 1st outside for loop
			
					for(int i=0; i<num_of_words;i++)
		
						{//opening of 2nd inner for loop
				
							if(words_in_sentence[a].equalsIgnoreCase(words_in_sentence[i]) && a<totcount)
								{// opening of if 
									b++;
									count[a]=b;
								
								
							
								
								}// closing of if
							
							
						}// closing of 2nd inner of loop
					
					
					b=0;
				}// closing of 1st outside for loop
			
			
			
			
			
			// remove words that are repeating
			for(int a=0;a<=num_of_words;a++) {// opening 1st outer for loop
			
				for(int i=a+1;i<=num_of_words;i++) {// opening 2nd inner for loop
			
					
			 while(words_in_sentence[a].equalsIgnoreCase(words_in_sentence[i])  ) 
				 {//opening of while loop 1st outer
					
					 
					 
				 while(i<num_of_words) 
				 { //opening of while loop 2nd inner
				        
				        words_in_sentence[i]=words_in_sentence[i+1];	
				        words_in_sentence[num_of_words]=words_in_sentence[num_of_words+1];
				        
				        
				        count[i]=count[i+1];
				        count[num_of_words]=count[num_of_words+1];
			
				        i++;
			
				 } // closing of while loop 2nd inner
				 num_of_words=num_of_words-1;
				 i=a+1; 
				
					
				 }// closing of while loop 1st outer
			 
					
				 
				}// closing 2nd inner for loop
		
			
			}//closing of 1st outer for loop
			 num_of_words=num_of_words-1;
			
	
			
			
			//alphabetical order
			out.println("\n\n\n");
			
			
			
			return num_of_words;
			
		} 
		
	
		
		/* Method alpha()
		 input:
	     words_in_sentence-words in the sentence
	     count-counts the number of the same words
	     num_of_words-number of words counted
	     totcount- max amount of words were counted as the same type
	     in- reference to input file
	     out- reference to output file
		 
		 process:
	     orders the words alphabetically
	     
		 
		 output:
		 print the words and counts
		 
		 */
		public static void alpha(String []words_in_sentence,int[]count,int num_of_words,int totcount, Scanner in,PrintWriter out) {

			int temp2;
			String temp;
			
			
			for(int a=0;a<=num_of_words;a++) {// opening 1st outer for loop
				
				for(int i=a+1;i<=num_of_words;i++) {// opening 2nd inner for loop
			
					
					
					
			 if(words_in_sentence[a].compareToIgnoreCase(words_in_sentence[i])>0  ) 
				 {//opening of if loop 1st outer
					
				 temp = words_in_sentence[i];
				 words_in_sentence[i] = words_in_sentence[a];
				 words_in_sentence[a] = temp;
				 
				 temp2 = count[i];
				 count[i] = count[a];
				 count[a] = temp2;
					 
				
				
					
				 }// closing of if loop 1st outer
			 
					
				 
				}// closing 2nd inner for loop
		
			
			}//closing of 1st outer for loop
			
			
			//prints the final words and the counted appearances
			for(int a=0;a<=num_of_words;a++)
			{
				out.print(words_in_sentence[a]+"\t");	
				out.println(count[a]);
			}
		}
		
		
}
