import {Link} from "react-router-dom";
import {Card, CardBody, CardHeader, CardSubtitle, CardText, CardTitle} from "reactstrap";

export const BookDetails = ({book}) =>
{
    return(
        <Card key = {book.id}  className={"card"}  width={'500px'} style = {{marginTop: '25px', cursor:'pointer'}} >
                <CardHeader style={{backgroundColor: '#03b1fc'}} >
                    <CardTitle style={{textAlign:'center'}}>
                    {book.name}
                    </CardTitle>
                </CardHeader>
                <CardBody>
                    <CardSubtitle>Author  : {book.author} </CardSubtitle>
                    Edition : {book.edition}<br/>
                    Language : {book.language}
                    <CardText >
                        <h4 style={{marginTop: '15px'}}>Description</h4>
                        {book.desc}
                    </CardText>
                </CardBody>
        </Card>
    )
}