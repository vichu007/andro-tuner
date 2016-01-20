# Introduction #

Here I will gather general requirements for tuner. There will be small amount of requirements, because this is fairly simple project. My aim is to learn software development process, android framework and signal processing in general.

# Physical specification #

**Should run on android 2.1 and onward.**

# Software spec #

## User stories ##

## Code format ##

All source code should follow strict formating. Most notable features are:
  * extra spaces
  * curly braces on new line
  * indentation is 4 spaces

Example: Bad style

```
public void exampleCode(String styleName){
       System.out.println(styleName + " is not okay");
}
```

Example: Good style
```
public void exampleCode( String styleName )
{
    System.out.println( styleName + " is OKAY" );
}
```

## UI look and feel ##
TODO

## Technical information ##

I'm not sure yet, what algorithm I should use to process audio input. There are several Fast Fourier transform algorithms for java. Best choices seem to be:

  * JTransforms
  * Apache Commons Math that contains Linear Algebra libraries.
  * Smaller scale libraries. (Have to search internet)