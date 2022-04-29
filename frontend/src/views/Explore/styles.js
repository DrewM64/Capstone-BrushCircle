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
            backgroundImage: 'url("/robert-keane-rlbG0p_nQOU-unsplash.jpg"',
            backgroundSize: "cover",
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
        },
        exploreTextContainer: {
            margin: "0 0 10px 60px",
            a: {
                fontSize: "22px",
                textDecoration: "none",
            }
        },
        moreLink: {
            display: "flex",
            justifyContent: "center",
            a: {
                fontSize: "22px",
                textDecoration: "none",
            }
        },
        categoriesContainer: {
            maxWidth: contentWidth,
            margin: "0 auto 40px auto",
        },
        linksContainer: {
            display: "flex",
            justifyContent: "space-between",
            margin: "0 52px 20px 52px",
        },
        categories: {
            display: "flex",
            justifyContent: "space-evenly",
        }
    }
}

export default makeStyles;