import React, {useState} from "react";
import {View, Text, StyleSheet, TextInput, Button} from "react-native";
import {addData, getData} from "../service";

export const AddNotes = ({navigation}) =>
{
    const [title,setTitle] = useState('');
    const [desc,setDesc] = useState('');




    const addNotes =() =>
    {
        let id = getData().length + 1;
        for(let i = 1;i<=100;i++)
        {
            let m = getData().map((item) => item.id === id);
            if(!m)
            {
                id =i;
                break;
            }
        }
        addData({title,desc,id});
        navigation.navigate('Dashboard');
    }

    return(
        <View style={styles.container}>
            <TextInput onChangeText={(t)=> setTitle(t)} placeholder={'Title'} style={{...styles.textInputStyle,marginTop:15}}/>
            <TextInput onChangeText={(t) => setDesc(t)} placeholder={'Description'} multiline={true} numberOfLines={6}
                style={{...styles.textInputStyle,borderRadius:20}}/>
            <View style={{width:160}}><Button  type={'button'}  title={'Add'} onPress={addNotes}/></View>
        </View>
    )
}

const styles = StyleSheet.create({
    container :{
        alignItems:'center'
    },
     textInputStyle: {
        borderColor: "#0074D9",
        borderWidth: 2,
        borderRadius: 10,
        fontSize: 20,
        padding: 5,
        width: "60%",
        marginBottom: 20,
         textAlign:'center'
    }
})

