import { Link } from "react-router-dom"
import "./LinkButton.css"


const LinkButton = (props) => {
    return (
        <div >
            <Link to={props.url}>
                <button className="linkButton" type="button">
                    {props.children}
                </button>
            </Link>
        </div>
    )

}

export default LinkButton