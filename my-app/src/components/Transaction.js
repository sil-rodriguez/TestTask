import React, { Component } from 'react';
import PropTypes from 'prop-types';

class Transaction extends Component {
  static propTypes = {
    id: PropTypes.string.isRequired,
    type: PropTypes.string.isRequired,
    amount: PropTypes.number.isRequired,
    date: PropTypes.string.isRequired
  };

  render() {
    const {
      props: { id, type, amount, date},
    } = this;

    return (
        <div label={this.props.id}>
          <p>
            <strong>Id:</strong> {this.props.id}
          </p>
          <p>
            <strong>Type:</strong> {this.props.type}
          </p>
          <p>
            <strong>Amount:</strong> {this.props.amount}
          </p>
          <p>
            <strong>Date:</strong> {this.props.date}
          </p>
        </div>
    );
  }
}

export default Transaction;
