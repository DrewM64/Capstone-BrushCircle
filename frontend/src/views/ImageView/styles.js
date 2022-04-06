const createStyles = () => {
    let styles = {
        container: {
            backgroundColor: "backgroundColor1",
            height: "100vh",
        },
        imageContainer: {
            display: "flex",
            justifyContent: "center",
            img: {
                height: "70vh",
                borderRadius: "8px",
                cursor: "grabbing",
            },
        },
        overlayContainer: {
            position: "absolute",
            backgroundColor: "white",
            borderTop: "2px solid lightgrey",
            height: "35vh",
            width: "100vw",
            bottom: "0",
        }
    }

    return styles;
}

export default createStyles;