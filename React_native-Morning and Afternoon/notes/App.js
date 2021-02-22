import React from 'react';
import {NavigationContainer} from "@react-navigation/native";
import Login from "./components/Login";
import {createStackNavigator} from "@react-navigation/stack";
import Dashboard from "./components/Dashboard";
import {AddNotes} from "./components/AddNotes";
import {createStore} from "redux";
import allreducer from "./redux/allreducer";
import {Provider} from "react-redux";

const Stack = createStackNavigator();
const store = createStore(allreducer,window.__REDUX_DEVTOOLS_EXTENSION__ && window.__REDUX_DEVTOOLS_EXTENSION__());

export default function App() {
  return (
      <Provider store={store}>
    <NavigationContainer >
      <Stack.Navigator>
          <Stack.Screen name={'Login'} component={Login}/>
          <Stack.Screen name={'Dashboard'} component={Dashboard}/>
          <Stack.Screen name={'AddNotes'} component={AddNotes} />
      </Stack.Navigator>
    </NavigationContainer>
      </Provider>
  );
}