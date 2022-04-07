import { Box, TextField, InputAdornment, Button, IconButton, Typography, TableContainer, Paper, Table, TableHead, TableRow, Tab, TableCell, TableBody } from '@mui/material';
import SearchIcon from '@mui/icons-material/Search';
import React from 'react'
import PersonAddAltIcon from '@mui/icons-material/PersonAddAlt';

import makeStyles from './styles'
function AdminPanel(props) {
    const nums = [1, 2, 3, 4, 5, 6, 7, 8, 9]
    const { value, index } = props;
    const styles = makeStyles(value, index);

    return (
        <Box sx={styles.container}>
            <Box sx={styles.adminHeader}>
                <TextField
                    sx={styles.searchField}
                    placeholder="Search"
                    size='small'
                    InputProps={{
                        startAdornment: <InputAdornment position='start'><SearchIcon /></InputAdornment>
                    }}
                />
                <Button variant='contained' >Search</Button>
                <Button variant='contained' sx={styles.addUserButton}><PersonAddAltIcon /></Button>
            </Box>
            <hr />
            <Box sx={styles.resultsContainer}>
                <Typography>7 Results</Typography>
                <TableContainer component={Paper}>
                    <Table>
                        <TableHead>
                            <TableRow>
                                <TableCell>User Email</TableCell>
                                <TableCell>Account ID</TableCell>
                            </TableRow>
                        </TableHead>
                        <TableBody>
                            {nums.map((val, index) => (
                                <TableRow key={index}>
                                    <TableCell>{val}</TableCell>
                                    <TableCell>{val}</TableCell>
                                </TableRow>
                            ))}
                        </TableBody>
                    </Table>
                </TableContainer>
            </Box>
        </Box>
    )
}

export default AdminPanel