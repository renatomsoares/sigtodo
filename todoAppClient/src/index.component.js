import React, { Component } from 'react';

import axios from 'axios';
import TaskRow from './taskRow.component';

export default class Index extends Component {

  constructor(props) {
      super(props);
      this.state = {tasks: []};
    }
    componentDidMount(){
      axios.get('http://localhost:8081/JavaServerFaces/api/task')
        .then(response => {
          this.setState({ tasks: response.data });
        })
        .catch(function (error) {
          console.log(error);
        })
        console.log("aqui" + this.state.tasks)
    }

    tabRow(){
      return this.state.tasks.map(function(object, i){
          return <TaskRow obj={object} key={i} />;
      });
    }

    render() {
      return (
        <div>
          <h3 align="center">Lista de Tarefas</h3>
          <table className="table table-striped" style={{ marginTop: 20 }}>
            <thead>
              <tr>
                <th>Descrição</th>
                <th colSpan="2">Ações</th>
              </tr>
            </thead>
            <tbody>
              { this.tabRow() }
            </tbody>
          </table>
        </div>
      );
    }
  }