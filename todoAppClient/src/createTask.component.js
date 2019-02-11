import React, { Component } from 'react';
import axios from 'axios';

export default class CreateTask extends Component {
  constructor(props) {
    super(props);
    this.onChangeTaskDescription = this.onChangeTaskDescription.bind(this);
    this.onSubmit = this.onSubmit.bind(this);

    this.state = {
      task_description: '',
    }
  }
  onChangeTaskDescription(e) {
    this.setState({
      task_description: e.target.value
    });
  }

  onSubmit(e) {
    e.preventDefault();
    const obj = {
      task_description: this.state.task_description,
    };

    var bodyFormData = new FormData();
    bodyFormData.append("task_description", obj.task_description);

    axios({
        method: 'post',
        url: 'http://localhost:8081/SIGTodo/api/task',
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

    this.setState({
      task_description: '',
    })
  }
  

 
  render() {
    return (
        <div style={{ marginTop: 10 }}>
            <h3>Cadastrar Tarefa</h3>
            <form onSubmit={this.onSubmit}>
                <div className="form-group">
                    <label>Descrição:  </label>
                    <input 
                      type="text" 
                      className="form-control" 
                      value={this.state.task_description}
                      onChange={this.onChangeTaskDescription}
                      />
                </div>

                <div className="form-group">
                    <input type="submit" value="Salvar" className="btn btn-primary"/>
                </div>
            </form>
        </div>
    )
  }
}