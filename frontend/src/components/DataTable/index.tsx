import axios from "axios"
import { useEffect, useState } from "react"
import { SalePage } from "types/sale"
import { formatLocalDate } from "utils/format"
import { BaseUrl } from "utils/requets"

const DataTable = () => {

    const [page, setPage] = useState<SalePage>({ 
        first: true,
        last: true,
        number: 0,
        totalElements: 0,
        totalPages: 0,
    })

    useEffect(() => {
        axios.get(`${BaseUrl}/sales/?page=0&size=10&sort=date,desc`)
        .then((response) => {
            setPage(response.data)
        })
    }, [])

    return(
<div className="table-responsive">
    <table className="table table-striped table-sm">
        <thead>
            <tr>
                <th> </th>
                <th>Data</th>
                <th>Vendedor</th>
                <th>Visitados</th>
                <th>Negócios</th>
                <th>Valor</th>
            </tr>
        </thead>
        <tbody>
            {page.content?.map(item => (
                 <tr key={item.id}>
                 <td>img</td>
                 <td>{item.seller.name}</td>
                 <td>{formatLocalDate(item.date, "dd/MM/yyyy")}</td>
                 <td>{item.visited}</td>
                 <td>{item.deals}</td>
                 <td>{item.amount.toFixed(2)}</td>
             </tr>
            ))}
        </tbody>
    </table>
</div>


    )
}

export default DataTable