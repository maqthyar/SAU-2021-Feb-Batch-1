import logo from './logo.svg';
import './App.css';
import {BookList} from "./Components/BookList";
import {Switch,BrowserRouter,Route} from "react-router-dom";
import {BookDetails} from "./Components/BookDetail";
import {getData} from "./service";



function App() {

  const bookWithId = (props) =>{
      const id = props.match.params.bookId;

      return (
          <BookDetails book={getData().filter((item)=> item.id === id)[0]}/>
      )
  }

  return (
    <div>
        <BrowserRouter>
            <Switch>
                <Route path={'/'} component={BookList} exact></Route>
                <Route path={'/:bookId'} component={bookWithId}></Route>
            </Switch>
        </BrowserRouter>
    </div>
  );
}

export default App;
