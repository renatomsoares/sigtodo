// edit.component.js

import React, { Component } from 'react';
import axios from 'axios';

export default class EditTask extends Component {
  constructor(props) {
    super(props);
    this.onChangeDescription = this.onChangeDescription.bind(this);
    this.onSubmit = this.onSubmit.bind(this);

    this.state = {
      task_description: '',
    }
  }

    onChangeDescription(e) {
    this.setState({
      id: this.props.match.params.id,
      task_description: e.target.value
    });
  }

  onSubmit(e) {
    e.preventDefault();

    console.log("imprimindo state:" + this.state.task_description)

        var bodyFormData = new FormData();
        bodyFormData.append("task_description", this.state.task_description);
        bodyFormData.append("task_id", this.state.task_description);
    
        axios({
            method: 'put',
            url: 'http://localhost:8081/SIGTodo/api/task?task_id='+this.props.match.params.id+'&task_description='+this.state.task_description,
            data: bodyFormData,
            config: { headers: {'Content-Type': 'multipart/form-data' }}
            })
            .then(function (response) {
              window.location.href = 'http://localhost:3000/index'
              console.log(response);
            })
            .catch(function (response) {
                //handle error
                console.log(response);
            });




    this.props.history.push('/index');

    
  }
 
  render() {
    return (
        <div style={{ marginTop: 10 }}>
            <h3 align="center">Atualizar Tarefa</h3>
            <form onSubmit={this.onSubmit}>
                <div className="form-group">
                    <label>Descrição:  </label>
                    <input 
                      type="text" 
                      className="form-control" 
                      value={this.state.task_description}
                      onChange={this.onChangeDescription}
                      />
                </div>
              
                <div className="form-group">
                    <input type="submit" 
                      value="Atualizar Tarefa" 
                      className="btn btn-primary"/>
                </div>
            </form>
        </div>
    )
  }
}