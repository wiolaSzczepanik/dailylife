import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';

class App extends Component {
    state = {
        isLoading: true,
        tasks: []
    };

    async componentDidMount() {
        const response = await fetch('/api/tasks/');
        const body = await response.json();
        this.setState({ tasks: body, isLoading: false });
    }

    render() {
        const {tasks, isLoading} = this.state;

        if (isLoading) {
            return <p>Loading...</p>;
        }

        return (
          <div className="App">
            <header className="App-header">
              <img src={logo} className="App-logo" alt="logo" />
              <h1 className="App-title">Welcome to React</h1>
            </header>
            <p className="App-intro">
                <h2>Task list</h2>
                {tasks.map(task =>
                    <div key={task.id}>
                        {task.description}
                    </div>
                )}
            </p>
          </div>
        );
    }
}

export default App;
