# Picasso

## Team Members

Ben Slater, Caleb Choe, Chapin Bassi, Garret Mize, Will Xue

## About

An application that allows the user to create expressions that
evaluate to colors and then eventually to images.


### Current supported functions

* Unary Functions
    * Abs
    * Cos
    * Tan
    * Sin
    * Floor
    * Ceil
    * Wrap
    * Atan
    * Clamp
    
* Multi-Argument Functions
    * Imagewrap
    
* Binary Operators
    * +
    

### Extensions

* Display the current defined variable names and their values on the right panel
    * Added variables can also be removed
    * If a newly added variable has the same name as an existing variable, the new variable will override the existing
* Display a history of expressions (attempted evaluations included) on the right panel
    * The most recent expressions will be at the top
    * To set the input to an expression click the "set current expression" button next to the expression

## Project Organization

`src` - the source code for the project

`conf` - the configuration files for the project

The `images` directory contains some sample images generated from Picasso.  Some of the expressions for these images can be found in the `expressions` directory.
