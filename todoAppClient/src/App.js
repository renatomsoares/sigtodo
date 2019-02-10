import React, { Component } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import { BrowserRouter as Router, Switch, Route, Link } from 'react-router-dom';
import EditTask from './editTask.component';
import CreateTask from './createTask.component';
import Index from './index.component';

class App extends Component {
  render() {
    return (
      <Router>
        <div className="container">
          <nav className="navbar navbar-expand-lg navbar-light bg-light">
            <Link to={'/index'} className="navbar-brand">SIGTodo</Link>
            <div className="collapse navbar-collapse" id="navbarSupportedContent">
              <ul className="navbar-nav mr-auto">
              <li className="nav-item">
                  <Link to={'/index'} className="nav-link">Início</Link>
                </li>
                <li className="nav-item">
                  <Link to={'/create'} className="nav-link">Cadastrar Tarefa</Link>
                </li>
              </ul>
            </div>
          </nav> <br/>

          <Switch>
              <Route exact path='/create' component={ CreateTask } />
              <Route path='/edit/:id' component={ EditTask } />
              <Route path='/index' component={ Index } />
          </Switch>
        </div>
      </Router>
    );
  }
}

export default App;