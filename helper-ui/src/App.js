import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';

class App extends Component {
    state = {
        isLoading: true,
        tasks: [],
    };

    async loadTasks() {
        const response = await fetch('/api/tasks/');
        const body = await response.json();
        this.setState({ tasks: body, isLoading: false});
    }

    async componentDidMount() {
        return this.loadTasks();
    }

    async handleUsernameSubmission(e) {
        if(e) e.preventDefault();
        const task = this.refs.description.value;

        const response = await fetch('/api/tasks/', {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                description: task
            })
        });
        const body = await response.json();
        console.log('Added task ', body);
        return this.loadTasks();
    }

    async handleDeleteClick(id) {

        await fetch('/api/tasks/' + id, {
            method: 'DELETE'
        });

        console.log('Deleted task ' + id);
        await this.loadTasks();
    }

    async handleMarkClick(id) {

        await fetch('/api/tasks/' + id, {
            method: 'PUT'
        });

        console.log('Mark task ' + id);
        await this.loadTasks();
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
                        {task.description} <a href="#" onClick={() => this.handleDeleteClick(task.id)}>Delete</a>
                        <a href="#" onClick={() => this.handleMarkClick(task.id)}> Done</a>
                    </div>

                )}
            </p>
              <p>
                  <h2>Add task</h2>
                  <form onSubmit={this.handleUsernameSubmission.bind(this)}>
                      <input placeholder="enter task" ref="description" />
                      <input type="submit" value="Add task" />
                  </form>
              </p>
          </div>
        );
    }
}

export default App;
