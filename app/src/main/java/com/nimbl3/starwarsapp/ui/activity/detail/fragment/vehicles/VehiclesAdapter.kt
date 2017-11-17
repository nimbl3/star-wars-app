package com.nimbl3.starwarsapp.ui.activity.detail.fragment.vehicles

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nimbl3.starwarsapp.R
import com.nimbl3.starwarsapp.query.AllVehiclesQuery.Vehicle
import kotlinx.android.synthetic.main.item_vehicle.view.*
import kotlin.properties.Delegates

open class VehiclesAdapter : RecyclerView.Adapter<VehiclesViewHolder>() {

    open var vehicles by Delegates.observable(listOf<Vehicle>()) { _, _, _ ->
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VehiclesViewHolder =
            VehiclesViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_vehicle, parent, false))

    override fun onBindViewHolder(holder: VehiclesViewHolder, position: Int) {
        holder.bind(vehicles[position])
    }

    override fun getItemCount(): Int = vehicles.size
}

class VehiclesViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val tvItemVehicleName = itemView.tvItemVehicleName
    private val tvItemVehicleModel = itemView.tvItemVehicleModel
    private val tvItemVehicleCrew = itemView.tvItemVehicleCrew
    private val tvItemVehicleClass = itemView.tvItemVehicleClass

    fun bind(vehicle: Vehicle) {
        tvItemVehicleName.text = vehicle.name()
        tvItemVehicleModel.text = vehicle.model()
        tvItemVehicleCrew.text = vehicle.crew()
        tvItemVehicleClass.text = vehicle.vehicleClass()
    }
}