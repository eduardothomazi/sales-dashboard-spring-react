import axios from "axios";
import Pagination from "components/Pagination";
import { useEffect, useState } from "react";
import { SalePage } from "types/sale";
import { formatLocalDate } from "utils/format";
import { BASE_URL } from "utils/requests";

function DataTable() {

    const [activePage, setActivePage] = useState(0);
    const [page, setPage] = useState<SalePage>({
        first: true,
        last: true,
        number: 0,
        totalElements: 0,
        totalPages: 0
    });

    useEffect(() => {
        axios.get(`${BASE_URL}/sales?page=${activePage}&sort=date,desc`)
            .then(response => {
                setPage(response.data);
            })
    }, [activePage])

    const changePage = (index: number) => {
        setActivePage(index);
    }

    return (
        <>
        <Pagination page={page} onPageChange={changePage}/>
            <div className="table-responsive">
                <table className="table table-striped table-sm">
                    <thead>
                        <tr>
                            <th>Date</th>
                            <th>Seller</th>
                            <th>Visited Clients</th>
                            <th>Deals</th>
                            <th>Values</th>
                        </tr>
                    </thead>
                    <tbody>
                        {page.content?.map(x => (
                            <tr key={x.id}>
                                <td>{formatLocalDate(x.date, "dd/MM/yyyy")}</td>
                                <td>{x.seller.name}</td>
                                <td>{x.visited}</td>
                                <td>{x.deals}</td>
                                <td>{x.amount.toFixed(2)}</td>
                            </tr>
                        ))}


                    </tbody>
                </table>
            </div>
        </>
    );
}

export default DataTable;