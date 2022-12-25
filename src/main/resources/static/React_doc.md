# key note of React working:

### Case of Class E6:
#### render() function
The render() function should be pure, meaning that it does not modify component state, it returns the same result each time it’s invoked, and it does not directly interact with the browser.

#### Unmounting
This method is called when a component is being removed from the DOM:
componentWillUnmount()

#### constructor()
**constructor(props).** If you don’t initialize state and you don’t bind methods, you don’t need to implement a constructor for your React component.
call super(props) before any other statement

### state : 
Constructor is the only place where you should assign this.state directly. In all other methods, you need to use this.setState() instead.

```
constructor(props) {
super(props);
// Don't do this!
this.state = { color: props.color };
}
```

