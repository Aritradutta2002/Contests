package com.aritra.contests.cses;

import java.util.*;
import java.io.*;

public class JosephusOptimized {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        Deque<Integer> circle = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            circle.addLast(i);
        }
        
        StringBuilder result = new StringBuilder();
        
        while (circle.size() > 1) {
            circle.addLast(circle.removeFirst());
            result.append(circle.removeFirst()).append(" ");
        }
        
        result.append(circle.getFirst());
        
        System.out.println(result.toString());
    }
}


/*
	The Big Idea: Simulating a Circle
	The problem describes children standing in a circle. In programming, a circle is tricky to create directly. So, we use a clever trick! We use a queue, which is just like a line of people.

	Imagine all the children (e.g., numbered 1 to 7) standing in a line:
	[1, 2, 3, 4, 5, 6, 7]

	To make this line act like a circle, we can use a simple rule: "If you take someone from the front of the line and move them to the back, it's like everyone just took one step around the circle."

	The perfect tool in Java for this is a Deque (pronounced "deck"). It lets us easily add to the back (addLast) and remove from the front (removeFirst).

	## Code Breakdown
	The problem says "every other child is removed." This means we repeat two actions over and over:

	Skip one child.

	Remove the next child.

	This is exactly what the while loop in the code does.

	Java

	while (circle.size() > 1) {
		// This is the "Skip" step
		circle.addLast(circle.removeFirst());
		
		// This is the "Remove" step
		result.append(circle.removeFirst()).append(" ");
	}
	The "Skip" Step: circle.addLast(circle.removeFirst());
	This is the key trick. It takes the child at the very front of the line and immediately puts that same child at the very end of the line. The child is "skipped" for now and sent to the back to wait for their turn again.

	The "Remove" Step: result.append(circle.removeFirst()).append(" ");
	After the first child was skipped, a new child is now at the front. This is the "other child" who needs to be removed. We take this child from the front and permanently remove them from the line, recording their number in our result.

	## Walkthrough with Example (n = 7)
	Let's trace the code to see exactly how it gets the answer 2 4 6 1 5 3 7.

	Initial State:

	circle: [1, 2, 3, 4, 5, 6, 7]

	result: ""

	Round 1:

	Skip 1: Take 1 from the front, move to the back. circle is now [2, 3, 4, 5, 6, 7, 1]

	Remove 2: Take 2 from the front. circle is now [3, 4, 5, 6, 7, 1]

	result: "2 "

	Round 2:

	Skip 3: Take 3, move to the back. circle is now [4, 5, 6, 7, 1, 3]

	Remove 4: Take 4 from the front. circle is now [5, 6, 7, 1, 3]

	result: "2 4 "

	Round 3:

	Skip 5: Take 5, move to the back. circle is now [6, 7, 1, 3, 5]

	Remove 6: Take 6 from the front. circle is now [7, 1, 3, 5]

	result: "2 4 6 "

	Round 4:

	Skip 7: Take 7, move to the back. circle is now [1, 3, 5, 7]

	Remove 1: Take 1 from the front. circle is now [3, 5, 7]

	result: "2 4 6 1 "

	Round 5:

	Skip 3: Take 3, move to the back. circle is now [5, 7, 3]

	Remove 5: Take 5 from the front. circle is now [7, 3]

	result: "2 4 6 1 5 "

	Round 6:

	Skip 7: Take 7, move to the back. circle is now [3, 7]

	Remove 3: Take 3 from the front. circle is now [7]

	result: "2 4 6 1 5 3 "

	End of Loop:

	The while loop stops because the circle's size is now 1.

	The final line of code adds the last remaining child (7) to the result string.

	Final Output: 2 4 6 1 5 3 7
	
*/


