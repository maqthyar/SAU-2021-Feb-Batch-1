import {StyleSheet, Button, TextInput, View,Text,AsyncStorage} from "react-native";
import {useEffect} from "react";


import React, {useState} from "react";


const Login = ({navigation}) =>
{
    const [username,setUser] = useState("");
    const [err,seterr] = useState("");

    useEffect( () =>
    {
        checkAuth();
    },[])

    const checkAuth = async () => {
        const username = await AsyncStorage.getItem("username");

        if(username)
            navigation.navigate("Dashboard");
    }

    const logMein = () => {

        if(!username)
        {
            seterr("please enter valid username");
            return;
        }
        seterr("");
         AsyncStorage.setItem("username",username);
        navigation.navigate("Dashboard")

        console.log(username);

    }

    return(
        <View style={styles.container}>
            <Text style={styles.loginTextStyle} >Login</Text>
            <TextInput onChangeText={(text) => {setUser(text)}} style = {styles.textInputStyle} placeholder ="enter username" />
            <Text style = {styles.errmsg}>{err}</Text>
{/*
            <TextInput style={styles.textInputStyle} secureTextEntry={true} placeholder = "enter password" />
*/}
            <Button onPress={logMein}  title = "login"/>
        </View>
    )
};



const styles = StyleSheet.create({
    container: {
        flex: 1,
        justifyContent: "center",
        alignItems: "center"
    },
    loginTextStyle: {
        fontSize: 25,
        fontWeight: "700",
        marginVertical: 20
    },
    textInputStyle: {
        borderColor: "blue",
        borderWidth: 1,
        borderRadius: 5,
        fontSize: 20,
        padding: 5,
        width: "60%",
        marginBottom: 20
    },
    errmsg:{
        color: 'red'
    }
})

export default Login;