// TableRow.js

import React, { Component } from 'react';

class TaskRow extends Component {
  render() {
    return (
        <tr>
          <td>
            {this.props.obj.description}
          </td>
          <td>
            <button className="btn btn-primary">Edit</button>
          </td>
          <td>
            <button className="btn btn-danger">Delete</button>
          </td>
        </tr>
    );
  }
}

export default TaskRow;