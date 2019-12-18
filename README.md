# Ex1 // Author: Lior Samuel

The project shows complex functions that built from monoms that create polynomials.

There is an operator between the polynomial or the monom.

Example of Complex Function: "Plus(Divid(18.0x+1.0x,Times(8.0x-2.0,1.0x^8-4.0)),2)"

What about the project?

Monum:
In this class, a "monom" built in the form of ax ^ b appears,
a is a real number (the coefficient) and b (the power) is a positive number.

Polynomial:
The polynomial is constructed of monom and looks like this: f (x) = a_1X ^ b_1 + a_2x ^ b_2 ... a_nX ^ b_n,
The polynomial realizes Polynom_able.

Complex functions
The functions are more complex than a simple polynomial and there are operators.
The class implements complex_function.

GUI_functions:
With this class we actually create the functions by X axis and Y axis and printable.
We use stdDraw to draw a function in Functions_GUI
There is also a function that gets parameters from JSON.
