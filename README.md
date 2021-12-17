# Picasso

## Team Members

Ben Slater, Caleb Choe, Chapin Bassi, Garret Mize, Will Xue

## About

An application that allows the user to create expressions that evaluate to colors and then eventually to images.


### Current supported basic functionalities

* Constants
    * Syntax: <any real number>[-]?[0-1]+(.[0-9]+)?
* Color
    * Syntax: [ constant,constant,constant ]
* String
    * Syntax: <any non-quote character between quotes>
* Variable
    * Syntax: <any alpha-numeric string> [a-zA-z]+[a-zA-Z0-9]*
* Assignment
    * Syntax: var = expr
* Parenthesis
    * Syntax: (expr)
* Single line comments
    * Syntax: // Comment
* Unary Functions
    * Syntax: fun(expr)
    * floor   // round down
    * ceil    // round up
    * abs     // absolute value
    * clamp   // clamp results to [-1, 1] (e.g., 1.5 -> 1)
    * wrap    // wrap results around [-1, 1] (e.g., 1.5 -> -0.5)
    * sin     // sine
    * cos     // cosine
    * tan     // tangent
    * atan    // arc tangent
    * exp     // e ^ parameter
    * log     // log -- use the absolute value of the parameter
    * rgbToYCrCb // convert color from RBG to luminance / chrominance space
    * yCrCbtoRGB // convert color to RGB from luminance / chrominance space
 
* Multi-Argument Functions
    * Syntax: fun(expr,...)
    * perlinColor(expr, expr) // create random color based on 2D noise

    * perlinBW(expr, expr)    // create grey scale color based on 2D noise

   // imports image, tiling it so it may be repeated
    * imageWrap(string, x-coord-expr, y-coord-expr) 

   // imports image, clipping it so it only appears once
    * imageClip(string, x-coord-expr, y-coord-expr) 

   // If you look at the example on the Intrinsics page, it includes an
   // arbitrary expression for x and y, so those may go out of the -1 to 1
   // bounds you are using. Thus clip and wrap are two different
   // ways to guarantee those values passed to the image's f(x, y) function
   // are within the bounds.

    * random()   // returns random color (actually no arguments :) )
    
* Binary Operators
    * Syntax: expr op expr
    * ^   // exponentiate
    * *   // times
    * /   // divide
    * +   // plus
    * -   // minus
    * %   // mod
    
* Unary Operator
    * Syntax: op expr
    * !   // negate (i.e., invert) a color



Operators have the following precedence (listed from highest to lowest):

()	parentheses
!	unary operators
^	exponentiation
*, /, %	multiplicative operators
+, -	additive operators
=	assignment
    
### Extensions

* Display the current defined variable names and their values on the right panel
    * Added variables can also be removed
    * If a newly added variable has the same name as an existing variable, the new variable will override the existing
* Display a history of expressions (attempted evaluations included) on the right panel
    * The most recent expressions will be at the top
    * To set the input to an expression click the "set current expression" button next to the expression 
* Allow users to "debug" expressions by using the mouse to display the point and evaluated values at that point
        * Move the move to a certain point returns the coordinates of the image
        * Also returns the RGB values of the three coordinates (0-255).

## Project Organization

`src` - the source code for the project

`conf` - the configuration files for the project

The `images` directory contains some sample images generated from Picasso.  Some of the expressions for these images can be found in the `expressions` directory.
