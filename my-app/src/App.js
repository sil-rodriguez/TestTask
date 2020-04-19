import React from 'react';
import { render } from 'react-dom';

import TransactionExpansionPanel from './components/ExpansionPanel';

function App() {

  return (
    <div>
      <h1>Transactions</h1>
      <TransactionExpansionPanel> </TransactionExpansionPanel>
    </div>
  );
}

export default App;
