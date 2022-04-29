const makeStyles = () => {
    return {
        container: {
            minWidth: "140px",
            height: "140px",
            backgroundColor: "white",
            borderRadius: 1,
            border: "1px solid lightgrey",
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
                width: "140px",
                minHeight: "140px",
            }
        }
    }
}

export default makeStyles;