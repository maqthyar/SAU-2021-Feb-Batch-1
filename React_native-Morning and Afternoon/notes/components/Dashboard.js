import React, {useEffect, useState,useRef} from 'react';

import {View, Text, Button, StyleSheet, ScrollView} from "react-native";
import {deleteData, getData} from "../service";
import {AddNotes} from "./AddNotes";
import {useFocusEffect} from "@react-navigation/native"
import AsyncStorage from "@react-native-community/async-storage"

class Dashboard extends React.Component
{
    constructor(props)
    {
        super(props);
        this.state = {
            notes : getData()
        }
    }
    check = async () =>
    {
        const data = await AsyncStorage.getItem('notes');

        if(data)
        {
            this.setState({
                notes: JSON.parse(data)
            })
            console.log("beg",this.state.notes);
        }
    }
    componentDidMount()
    {
        this.check();

        this.props.navigation.addListener('focus',async () => {
          console.log('focus');
          this.setState({
              notes: getData()
          },async () =>
          {
              AsyncStorage.setItem('notes',JSON.stringify(this.state.notes));
              const data = await AsyncStorage.getItem('notes');
              if(data)
              {
                  console.log("After add",JSON.parse(data));
              }
          });

        });
    }

    render()
 {


     const notesList = this.state.notes.map((item) =>
     {
         return (
             <View key={item.id} style={styles.container}>
                 <View>
                     <Text style={styles.title}>{item.title}</Text>
                     <Text style={styles.desc}>{item.desc}</Text>
                 </View>
                 <View style={styles.btn}>
                     <Button color={'red'} title={'Delete'} onPress={() =>
                     {
                         deleteData(item);
                         this.setState({
                             notes: getData()
                         },() =>
                         {
                             AsyncStorage.setItem("notes",JSON.stringify(this.state.notes));
                         })
                     }}/>
                 </View>
             </View>
         );
     })

     return (
         <ScrollView>
             <View>
                 <View style={{...styles.container, marginBottom: 10}}>
                     <Button type={'button'}
                             title={'Add'} onPress={() =>
                     {
                         this.props.navigation.navigate('AddNotes')
                     }}/>
                 </View>
                 {getData().length === 0 ? <Text>No notes in the list</Text> : notesList}
             </View>
         </ScrollView>
     )
 }
}

const styles = StyleSheet.create({

    topContainer:{
        marginTop: 20
    },

    btn:{
        width: 200,
        alignSelf: 'flex-end'
    },

    container: {
        width: "95%",
        marginRight: "2.5%",
        marginLeft: "2.5%",
        height: 'auto',
        marginVertical: 8,
        backgroundColor: 'white'
    },
    title: {
        fontSize:16,
        color: "black",
        fontWeight: "700",
        padding: 5,
        marginLeft: 'auto',
        marginRight: 'auto'
    },
    desc: {
        fontSize: 16,
        color: "black",
        fontWeight: "500",
        padding: 5,
        alignSelf: "flex-start"

    }
});

export default Dashboard;