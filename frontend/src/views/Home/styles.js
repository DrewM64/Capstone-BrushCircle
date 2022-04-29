const makeStyles = () => {
    const contentWidth = "1200px";
    return {
        container: {
            width: "100vw",
            height: "100vh",
        },
        headingContainer: {
            display: "flex",
            justifyContent: "center",
            alignItems: "center",
            height: "250px",
            maxWidth: contentWidth,
            margin: "auto",
            h2: {
                fontWeight: "500"
            }
        },
        productsContainer: {
            maxWidth: contentWidth,
            margin: "0 auto 20px auto",
        },
        products: {
            display: "flex",
            justifyContent: "center",
            alignItems: "center",
            columnGap: "15px",
            rowGap: "15px",
            flexWrap: "wrap",
        }
    }
}

export default makeStyles;