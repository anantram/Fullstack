const React = require('react');
const ReactDOM = require('react-dom');

class App extends React.Component {
	constructor(props) {
		super(props);
		this.state = {users: [],
			currentUserId :null,
			currentUser: null,
			newUser: null,
			refresh: false
		};
		
		this.addUser = this.addUser.bind(this);
		this.handleInputChange = this.handleInputChange.bind(this);
	}


	componentDidMount() {
		fetch('http://localhost:8080/users')
		.then(res => res.json())
		.then((data) => {
			this.setState({ users: data })
		 })
		.catch(console.log)
	}


	getUserDetails(id) {
		fetch('http://localhost:8080/users/' + id)
		.then(res => res.json())
		.then((data) => {
			this.setState({ currentUser: data })}
		)
		.catch(console.log)
	}

	addUser(event)
	{
		event.preventDefault();
		let newValue = this.state
		this.setState({refresh: false})
		let  output = {
			name: { 
					firstName: newValue.firstName,
					middleName: newValue.middleName,
					lastName: newValue.lastName
				},
			location: {
				address: newValue.address,
				city: newValue.city,
				state: newValue.state,
				coutry:newValue.country
			},
			gender: newValue.gender
		};

		return fetch('http://localhost:8080/users', {
			method: 'POST',
			headers: {
				'Accept': 'application/json',
				'Content-Type': 'application/json',
			},
			body : JSON.stringify(output)
		}).then(res => {
			this.setState({refresh: true})
			window.location.reload(false);
		})
	}

	handleInputChange(event) {
		event.preventDefault()
    const target = event.target;
    const value = target.value;
		const name = target.name;
		
    this.setState({[name]: value});
		console.log(this.state);
  }

	updateBlogPost(id, data) {
		return fetch('http://localhost:8080/users/' + id, {
			method: 'PUT',
			mode: 'CORS',
			body: JSON.stringify(data),
			headers: {
				'Content-Type': 'application/json'
			}
		}).then(res => {
			return res;
		}).catch(err => err);
	}

	render() {
		return (
			<div>
				<Users users={this.state.users} 
				onClick={(user_id) => this.getUserDetails(user_id)} 
				refresh={this.state.refresh}/>
				
				<UserDetails userid={this.state.currentUser} 
				onSubmit={(newData) => this.updateBlogPost(newData)}/>
				
				 <form onSubmit={this.addUser}>
					<p>Enter your name:</p>
					<input
						type='text'
						name='firstName'
						onChange={this.handleInputChange}
					/>
					<p>Enter your age:</p>
					<input
						type='text'
						name='middleName'
						onChange={this.handleInputChange}
					/>
					<input
						type='text'
						name='lastName'
						onChange={this.handleInputChange}
					/>
					<input
						type='text'
						name='address'
						onChange={this.handleInputChange}
					/>
					<input
						type='text'
						name='city'
						onChange={this.handleInputChange}
					/>
					<input
						type='text'
						name='state'
						onChange={this.handleInputChange}
					/>
					<input
						type='text'
						name='gender'
						onChange={this.handleInputChange}
					/>
					<input
						type='text'
						name='country'
						onChange={this.handleInputChange}
					/>
					<button>Send data!</button>
				</form>
			</div>
		);
	}
}


class UserDetails extends React.Component {
	constructor(props)
	{
		super(props)
	}

	render()
	{
		if(null == this.props.userid)
		{
			return(
				<div>
					Select any person to see more details
					<div class="w3-modal">
						<div class="card-body"> </div>
					</div>
				</div>
			)
		}
		else
		{
			return(
				<div>
					<div class="w3-modal">
						<div class="card-body">
							<h5 class="card-title">{this.props.userid.name.firstName}</h5>
						</div>
					</div>
					<form onSubmit= {this.props.onSubmit}> 
						First name:<br></br>
						<input type="text" name="firstname" value="Mickey"></input>
						<br></br>
						<input type="text" name="lastname" value="Mouse"></input>
						<br></br>
						<input type="submit" value="Submit"></input>
					</form>
				</div>
			)
		}
	}
};

class Users extends React.Component {
	
	constructor(props) {
		super(props)
	}

	render(){
		return(
			<div>
				{
					this.props.users.map((user) => (
						<div >
							<div class="w3-panel w3-blue w3-card-4 w3-button" onClick={(user_id) => this.props.onClick(user.id)}>
								<div class="userGrid">
									<div><h5>{user.name.firstName}</h5></div>
									<div><h6>{user.name.middleName}</h6></div>
									<div><p>{user.name.lastName}</p></div>
									<div><button onClick={(user_id) => this.props.onClick(user.id)}>More Details</button></div>
								</div>
							</div>
						</div>
					))
				}
			</div>
		)
	}
}


const UsersList = ({userl}) => {
		return (
			<div>
				{
					userl.map((user) => (
						<div class="w3-panel w3-green w3-card-4">
							<div class="card-body">
								<h5 class="card-title">{user.name.firstName}</h5>
								<h6 class="card-subtitle mb-2 text-muted">{user.name.middleName}</h6>
								<p class="card-text">{user.name.lastName}</p>
							</div>
						</div>
					))
				}
		</div>
	)
};


ReactDOM.render(
	<App />,
	document.getElementById('user_details')
)