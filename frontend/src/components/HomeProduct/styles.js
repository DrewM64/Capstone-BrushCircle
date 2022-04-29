const makeStyles = () => {
    return {
        container: {
            width: "200px",
            height: "200px",
            overflow: "hidden",
            borderRadius: "5px",
            backgroundColor: "black",
            transition: "all 0.2s 0.01s",
            cursor: "pointer",
            border: "2px solid lightgrey",
            [':hover']: {
                border: "2px solid blue",
                backgroundColor: "galleryItemHoverColor",
                transition: "all 0.1s 0.01s",
            },
            img: {
                width: "200px",
                minHeight: "200px",
            }
        }
    }
}

export default makeStyles;