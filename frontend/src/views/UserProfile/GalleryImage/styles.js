const makeStyles = () => {
    return {
        container: {
            width: "200px",
            height: "200px",
            backgroundColor: "red",
            borderRadius: 1,
            overflow: "hidden",
            cursor: "pointer",
            borderRadius: "5px",
            border: "2px solid lightgrey",
            [':hover']: {
                border: "3px solid blue",
                backgroundColor: "galleryItemHoverColor",
                transition: "all 0.1s 0.01s",
            },
            img: {
                width: "200px",
                minHeight: "200px",
            }
        },
    }
}

export default makeStyles;