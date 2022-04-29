const makeStyles = () => {
    return {
        container: {
            position: "relative",
            display: "flex",
            justifyContent: "center",
            alignItems: "center",
            width: "330px",
            height: "330px",
            backgroundColor: "darkgrey",
            cursor: "pointer",
            borderRadius: "5px",
            overflow: "hidden",
            border: "2px solid lightgrey",
            [':hover']: {
                border: "2px solid blue",
                backgroundColor: "galleryItemHoverColor",
                transition: "all 0.1s 0.01s",
            },
            img: {
                width: "330px",
                minHeight: "330px",
                filter: "brightness(50%)",
            }
        },
        title: {
            color: "white",
            fontWeight: "500",
            fontSize: "40px",
            position: "absolute",
        }
    }
}

export default makeStyles;