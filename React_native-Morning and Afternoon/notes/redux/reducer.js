const notes = (state = [], action) =>
{
    switch (action.type)
    {
        case "ADD":
            return state.push(action.data);
        break;
        default :
            return state;
    }
}

export default notes