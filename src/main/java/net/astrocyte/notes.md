# Notes

**Creating a class**

* To create a class in IntelliJ, you right-click on the overarching folder. Then:
  * New > package.
  * Then add your all your class items relevant to that package.
  * Here, the package is called 'items' and contains all the item data.

* KaupenJoe is also practicing **package organisation** by doing this. This is something that I have not done yet. Up until now, my coding assignments have all had their classes contained within the src folder.

**Deferred Register**

* A data structure that behaves similarly to an ArrayList.
  * But, under the hood, a D.R. is VERY different to an ArrayList.
  * Stores lambdas (instructions for creating objects).
* What is it more specifically? A list that is given to Minecraft at the specific time that it is needed.
* That is the "deferred" nature of it.
* **Wrong:** My initial inclination was to compare it to JIT compilation, but that is not the case.
* **Correct:** D.R. behaves like a "to-do" list that only executes the exact moment it is needed. **Event-driven programming**

**What is the key difference between a Deferred Register and an ArrayList? (Lambda)**

* ArrayList holds the actual objects
* DeferredRegister holds recipes (**Lambda functions**) for making objects later
* https://www.w3schools.com/java/java_lambda.asp

*Example (from w3schools):*

import java.util.ArrayList;

public class Main {\
public static void main(String[] args) {\
ArrayList<Integer> numbers = new ArrayList<Integer>();\
numbers.add(5);\
numbers.add(9);\
numbers.add(8);\
numbers.add(1);\
numbers.forEach( (n) -> { System.out.println(n); } );\
}\
}

* This is a demonstration of how Lambda functions can be *more concise* compared to traditional methods like printing out each value using a for/for each loop.
* DeferredRegister *is like an ArrayList that holds lambda functions (recipes)*, and when Minecraft is ready, it executes all those lambdas to create and register the actual objects.

**What can you register?**

* A bunch of different objects (in the coding sense of the word).
  * Creative mode tabs.
  * Items.
  * Blocks.

**Checklist for adding items**

1. Created DeferredRegister to store item lambda functions (only need to do this once, at least for now).
2. Add a new registry object to the deferred register.
3. Accept that registry object into a creative mode tab. E.g., "Ingredients".
4. Create textures in assets folder.

**Assets folder and JSON files**

* In the context of a Minecraft assets folder, JSON (JavaScript Object Notation) files act as the instruction manuals for the game's visuals and sounds. 
* While your Java code defines the logic (what a block does, how much damage a sword deals), the assets folder is entirely client-side, meaning it handles only what the player sees and hears. 
* The JSON files inside don't contain image data themselves; instead, they tell Minecraft which textures to use, how to shape them, and when to display them.

**Checklist for adding blocks**

* This is a bit more complex.
* When you add a block into the game, you also need to do everything that you would do for an item.
* 