const { Component } = React

class EntryPage extends Component {

    constructor(props){
        super(props)

        this.state = {
            username:"",
            password:"",
            email:"",
            currentView: "signUp",
            registered: false,
            loggedIn: false,
            error: ""

        }
    }
    componentDidMount() {

    }


    changeView = (view) => {
        this.setState({
            currentView: view
        })
    }


registerUser( username, email, password) {
alert('here is the username '+ username )
    alert('register user in js method 1 ')
     fetch( 'http://localhost:8081/signUpUser?username='+username+'&email='+email+'&password='+password+'')
        .then(status)
       .then(response => response.text())
          .then(answer => {
            console.log(answer);

           alert("response" + answer)
           if(answer === "registered"){
           alert("yes its registered")
               this.setState({
                   registered: answer,
                   currentView: "logIn"
               });
               this.changeView("logIn")
           }
           else {
           this.setState({
              error: answer,
            })
            alert("there was an error :"+ answer)
           }
           },
           (error) => {
               alert(error);
           }
       )
        .catch(error => {
            alert(error);
        })
    }

   currentView = () => {
        switch(this.state.currentView) {
            case "signUp":
                return (
                    <form>
                        <h2>Sign Up!</h2>
                        <fieldset>
                            <legend>Create Account</legend>
                            <ul>
                                <li>
                                    <label for="username">Username:</label>
                                    <input type="text" id="username" name="username" required onChange={e =>this.state.username= e.target.value}/>
                                </li>
                                <li>
                                    <label for="email">Email:</label>
                                    <input type="email" id="email" name="email" required onChange={e =>this.state.email= e.target.value}/>
                                </li>
                                <li>
                                    <label for="password">Password:</label>
                                    <input type="password" id="password" name="password" required onChange={e => this.state.password= e.target.value}/>
                                </li>
                            </ul>
                        </fieldset>
                        <button type="button" onClick={() => this.registerUser(this.state.username,this.state.email,this.state.password)}>Submit</button>
                        <button type="button" onClick={ () => this.changeView("logIn")}>Have an Account?</button>
                    </form>
                )
                break
            case "logIn":
                return (
                    <form action="/loginUser"  method="GET">
                        <h2>Welcome Back!</h2>
                        <fieldset>
                            <legend>Log In</legend>
                            <ul>
                                <li>
                                    <label for="username">Username:</label>
                                    <input type="text" id="username"  name="username" required/>
                                </li>
                                <li>
                                    <label for="password">Password:</label>
                                    <input type="password" id="password" name="password" required/>
                                </li>
                                <li>
                                    <i/>
                                    <a onClick={ () => this.changeView("PWReset")} href="#">Forgot Password?</a>
                                </li>
                            </ul>
                        </fieldset>
                        <button type="submit">Login</button>
                        <button type="button" onClick={ () => this.changeView("signUp")}>Create an Account</button>
                    </form>
                )
                break
            case "PWReset":
                return (
                    <form>
                        <h2>Reset Password</h2>
                        <fieldset>
                            <legend>Password Reset</legend>
                            <ul>
                                <li>
                                    <em>A reset link will be sent to your inbox!</em>
                                </li>
                                <li>
                                    <label for="email">Email:</label>
                                    <input type="email" id="email" required/>
                                </li>
                            </ul>
                        </fieldset>
                        <button>Send Reset Link</button>
                        <button type="button" onClick={ () => this.changeView("logIn")}>Go Back</button>
                    </form>
                )
            default:
                break
        }
    }


    render() {
        return (
            <section id="entry-page">
                {this.currentView()}
            </section>
        )
    }
}

ReactDOM.render(<EntryPage/>, document.getElementById("app"))