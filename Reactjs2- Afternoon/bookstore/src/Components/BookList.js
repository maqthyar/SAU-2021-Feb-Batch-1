import {getData} from "../service";
import {Card, CardBody, CardHeader, CardSubtitle, CardText, CardTitle} from "reactstrap";
import {Link} from "react-router-dom";
import React,{useState} from "react";
import {SearchBookList} from "./SearchBookList";


export  function BookList()
{

    const [searchItem, setSearchItem] = useState('#@^&');
    const [books, setBooks] = useState(getData());

    const Get = () =>
    {
        return books.map((item) =>
        {
            return(
                <Card key = {item.id}  className={"card"}  width={'500px'} style = {{marginTop: '25px', cursor:'pointer'}} >
                    <Link to={`/${item.id}`} style = {{textDecoration:'none', color:'black'}}>
                        <CardHeader style={{backgroundColor: '#03b1fc'}} >
                            <CardTitle style={{textAlign:'center'}}>
                            {item.name}
                            </CardTitle>
                        </CardHeader>
                        <CardBody>
                            <CardSubtitle>Author  : {item.author} </CardSubtitle>
                            <div className={'row'}>
                                <div className={'col-6'}> Edition : {item.edition}</div>
                                <div className={'offset-2 col-4'}> Language : {item.language}</div>
                            </div>
                        </CardBody>
                    </Link>
                </Card>
            )
        })
    };

    const dynamicSearch = () =>
    {
        return books.filter((item) => item.name.toLowerCase().includes(searchItem.toLowerCase()));
    }

    const setItem = (e) =>
    {
        if(e.target.value !== '')
            setSearchItem(e.target.value)
        else
            setSearchItem('#@^&')

    }

    return(
        <div>
            <h2 style={{marginLeft:'30px'}}>Books </h2>
            <hr/>
            <div className={'sear'} >
                <input style={{width:'600px'}} type={'text'} name={'sch'} onChange={setItem}  placeholder={'Search Book here'}/>
                <SearchBookList  books= {dynamicSearch()} />
            </div>
            <Get />
        </div>
    )
}