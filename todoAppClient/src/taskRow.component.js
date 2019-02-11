// TableRow.js

import React, { Component } from 'react';
import 'font-awesome/css/font-awesome.min.css';



import { Link } from 'react-router-dom';
import axios from 'axios';

class TaskRow extends Component {
  
  translateBooleanReturn(value) {
    if (value) {
      return <button title="Marcar como pendente" className="btn btn-success"><i class="fa fa-check"></i></button>;
    } else {
      return <button title="Marcar como feito" className="btn btn-danger"><i class="fa fa-times"></i></button>;
    }
  }


  delete(props) {

    return function () {

      axios.delete('http://localhost:8081/SIGTodo/api/task?task_id='+props.obj.id)
            .then(window.location.href = 'http://localhost:3000/index')
            .catch(err => console.log(err))
    }
  }

  render() {
    return (
        <tr>
          <td>
            {this.props.obj.registerDate}
          </td>
          <td>
            {this.translateBooleanReturn(this.props.obj.completedTask) }
          </td>
          <td>
            {this.props.obj.description}
          </td>
          
          <td>
          <Link to={"/edit/"+this.props.obj.id} className="btn btn-primary">Atualizar</Link>
          </td>
          <td>
          <button onClick={this.delete(this.props)} className="btn btn-danger">Excluir</button>
          </td>
        </tr>
    );
  }
}

export default TaskRow;