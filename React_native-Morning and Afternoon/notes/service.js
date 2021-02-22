let notes = [
    {
        title: 'Title1',
        id: 1,
        desc: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Cum, deserunt eius eveniet nihil possimus quo' +
            '                vitae. Culpa dolore fugiat laborum nam nobis nostrum possimus, provident repudiandae rerum temporibus' +
            '                ullam unde.'
    },
    {
        title: 'Title2',
        id: 2,
        desc: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Cum, deserunt eius eveniet nihil possimus quo' +
            '                vitae. Culpa dolore fugiat laborum nam nobis nostrum possimus, provident repudiandae rerum temporibus' +
            '                ullam unde.'
    },
    {
        title: 'Title3',
        id: 3,
        desc: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Cum, deserunt eius eveniet nihil possimus quo' +
            '                vitae. Culpa dolore fugiat laborum nam nobis nostrum possimus, provident repudiandae rerum temporibus' +
            '                ullam unde.'
    }
]

export const getData = () =>
{
    return notes;
}

export const addData = (item) =>
{
    notes = Object.assign([], notes);
    notes.push(item);
}

export const deleteData = (data) =>
{
    notes = notes.filter((item) => data.id !== item.id);
}