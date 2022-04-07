const makeStyles = () => {
    return {
        container: {
            display: "grid",
            gridTemplateColumns: "500px auto",
            backgroundColor: "backgroundColor1",
            width: "100vw",
            height: "100vh",
            maxHeight: "100vh",
            overflow: "hidden",
        },
        infoContainer: {
            borderRight: "2px solid lightgrey"
        },
        contentContainer: {
            width: "100%",
            height: "100vh",
            overflow: "auto",
            margin: "40px 0 0 40px",
        },
        userCard: {
            display: "flex",
            flexDirection: "column",
            justifyContent: "center",
            alignItems: "center",
            backgroundColor: "white",
            border: "2px solid lightgrey",
            borderRadius: 3,
            width: "250px",
            margin: "40px auto 0 auto",
            overflow: "hidden",
        },
        userCardHeader: {
            display: "grid",
            padding: "15px",

        },
        imageContainer: {
            width: "100px",
            marginLeft: "auto",
            marginRight: "auto",
            height: "100px",
            borderRadius: "50%",
            overflow: "hidden",
            img: {
                width: "100px"
            }
        },
        productsTextContainer: {
            width: '100%',
            padding: "10px 0 10px 0",
            borderTop: "1px solid lightgrey",
            borderBottom: "1px solid lightgrey",
        },
        linksContainer: {
            display: "grid",
            width: "100%",
            gridTemplateColumns: "20px auto",
            justifyContent: "center",
            borderBottom: "1px solid lightgrey",
            padding: "15px",
            columnGap: "10px",
        },
        biographyContainer: {
            padding: "15px"
        },
        featuredContainer: {
            display: "",

        },
        featuredImages: {
            display: "flex",
            columnGap: "25px",
            overflow: "auto",
        },
        galleryContainer: {

        },
        galleryImages: {
            display: "flex",
            columnGap: "40px",
            rowGap: "40px",
            flexWrap: "wrap",
        },
    }
}

export default makeStyles;