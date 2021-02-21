import {Link} from "react-router-dom";
import {Button} from "reactstrap";

export const SearchBookList = ({books}) =>
{

    const x =  (books.map((item) => {
      return (
         <div >
             <Link to={`/${item.id}`} style={{textDecoration:'none'}}>
                <Button style={{borderRadius:'0px',width:'600px',border:'solid 1px'}} >
                    {item.name}
                </Button>
             </Link>
        </div>
      )
    }))

    return (
        <div>
            {x}
        </div>
    )

}