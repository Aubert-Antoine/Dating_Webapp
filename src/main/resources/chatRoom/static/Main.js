
class Messages extends React.Component {
constructor(props) {
		super(props);

	}
    render() {
        if (!this.props.messages) {
            return <div>No Messages yet...</div>
            }

        return (
            <div>
                  {this.props.messages.map((message,i) => {
                          if(message.messageType==="Question"){
                              return(QuestionMessage(message))

                          }
                          else {
                              return (AnswerMessage(message))
                          }
                        })
                  }
             </div>
        );
    }
}

function QuestionMessage(props){
  return (

<div id="questionMessage">
    <table >
        <tbody>
        <tr>
            <td>
                <div className="media w-50 mb-3">
                    <img src="https://res.cloudinary.com/mhmd/image/upload/v1564960395/avatar_usae7z.svg" alt="user" width="50" className="rounded-circle">
                    </img>
                    <div className="media-body ml-3">
                        <div className="bg-light rounded py-2 px-3 mb-2">
                            <p className="text-small mb-0 text-muted"> {props.messageText}</p>
                        </div>

                        <div className="row">
                            <div className="col-auto mr-auto">
                                <p className="small text-muted">{props.messageDate}</p>
                            </div>
                            <div className="col-auto">
                                <form action="/deleteMessage" method="get">
                                    <input name="id" type="hidden" value={props.id} readOnly/>
                                    <button type="submit" className="btn btn-outline-warning btn-sm"> Del</button>
                                    {/*https://getbootstrap.com/docs/4.0/components/buttons/*/}
                                </form>
                            </div>
                        </div>

                    </div>
                </div>
            </td>
        </tr>
        </tbody>
    </table>
</div>

  );
}
function AnswerMessage(props){
  return (
    <div id="answerMessage">
        <table >
            <tbody>
            <tr>
                <td></td>
                <td>
                    <div className="media w-50  ml-auto mb-3">
                        <div className="media-body">
                            <div className="bg-primary rounded py-2 px-3 mb-2">
                                <p className="text-small mb-0 text-white">{props.messageText}</p>
                            </div>

                            <div className="row">
                                <div className="col-auto mr-auto">
                                    <p className="small text-muted">{props.messageDate}</p>
                                </div>
                                <div className="col-auto">
                                    <form action="/deleteMessage" method="get">
                                        <input name="id" type="hidden" value={props.id} readOnly/>
                                        <button type="submit" className="btn btn-outline-warning btn-sm"> Del</button>
                                        {/*https://getbootstrap.com/docs/4.0/components/buttons/*/}
                                    </form>
                                </div>
                            </div>

                        </div>
                    </div>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
  )
}

class MessageArea extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            messages: []
        }
    }
    componentDidMount() {
        fetch("/MessageList")
            .then(res => res.json())
            .then(
                (response) => {
                    this.setState({
                        messages: response
                    });
                },
                (error) => {
                    alert(error);
                }
            )
    }
    render() {
        return (
            <div id="main">
                <Messages messages={this.state.messages}/>
            </div>
        );
    }
}

ReactDOM.render(
    <MessageArea />,
    document.getElementById('messageArea')
);